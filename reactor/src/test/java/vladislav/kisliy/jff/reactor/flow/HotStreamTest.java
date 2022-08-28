package vladislav.kisliy.jff.reactor.flow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SignalType;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class HotStreamTest {

    @Test
    public void hot() throws Exception {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        EmitterProcessor<Integer> emitter = EmitterProcessor.create(2);
        FluxSink<Integer> sink = emitter.sink();
        emitter.subscribe(collect(first));
        sink.next(1);
        sink.next(2);
        emitter.subscribe(collect(second));
        sink.next(3);
        sink.complete();
        assertTrue(first.size() > second.size());
    }

    @Test
    public void hotWithDelay() throws Exception {
        int factor = 10;
        log.info("start");
        CountDownLatch cdl = new CountDownLatch(2);
        Flux<Integer> live = Flux.range(0, 10).delayElements(Duration.ofMillis(factor))
                .share();
        List<Integer> one = new ArrayList<Integer>();
        List<Integer> two = new ArrayList<Integer>();
        live.doFinally(signalTypeConsumer(cdl)).subscribe(collect(one));
        Thread.sleep(factor * 2);
        live.doFinally(signalTypeConsumer(cdl)).subscribe(collect(two));
        cdl.await(5, TimeUnit.SECONDS);
        assertTrue(one.size() > two.size());
        log.info("stop");
    }

    @Test
    public void publish() throws Exception {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<Integer> three = new ArrayList<>();

        Flux<Integer> pileOn = Flux.just(1, 2, 3).publish().autoConnect(3)
                .subscribeOn(Schedulers.immediate());

        pileOn.subscribe(subscribe(one));
        assertEquals(one.size(), 0);
        pileOn.subscribe(subscribe(two));
        assertEquals(two.size(), 0);
        pileOn.subscribe(subscribe(three));

        assertEquals(one.size(), 3);
        assertEquals(two.size(), 3);
        assertEquals(three.size(), 3);
    }
    private Consumer<SignalType> signalTypeConsumer(CountDownLatch cdl) {
        return signal -> {
            if (signal.equals(SignalType.ON_COMPLETE)) {
                try {
                    cdl.countDown();
                    log.info("await()...");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    Consumer<Integer> collect(List<Integer> collection) {
        return collection::add;
    }

    private Consumer<Integer> subscribe(List<Integer> list) {
        return list::add;
    }
}
