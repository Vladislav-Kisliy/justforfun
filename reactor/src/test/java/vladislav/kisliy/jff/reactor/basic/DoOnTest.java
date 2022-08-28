package vladislav.kisliy.jff.reactor.basic;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;
import reactor.test.StepVerifier;
import reactor.core.publisher.Signal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
public class DoOnTest {
    @Test
    public void doOn() {
        List<Signal<Integer>> signals = new ArrayList<>();
        List<Integer> nextValues = new ArrayList<>();
        List<Subscription> subscriptions = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        List<SignalType> finallySignals = new ArrayList<>();
        Flux<Integer> on = Flux
                .<Integer>create(sink -> {
                    sink.next(1);
                    sink.next(2);
                    sink.next(3);
                    sink.error(new IllegalArgumentException("oops!"));
                    sink.complete();
                })
                .doOnNext(nextValues::add)
                .doOnEach(signals::add)
                .doOnSubscribe(subscriptions::add)
                .doOnError(IllegalArgumentException.class, exceptions::add)
                .doFinally(finallySignals::add);

        StepVerifier
                .create(on)
                .expectNext(1, 2, 3)
                .expectError(IllegalArgumentException.class)
                .verify();

        signals.forEach(log::info);
        assertEquals(4, signals.size());

        finallySignals.forEach(log::info);
        assertEquals(finallySignals.size(), 1);

        subscriptions.forEach(log::info);
        assertEquals(subscriptions.size(), 1);

        exceptions.forEach(log::info);
        assertEquals(exceptions.size(), 1);
        assertTrue(exceptions.get(0) instanceof IllegalArgumentException);

        nextValues.forEach(log::info);
        assertEquals(Arrays.asList(1, 2, 3), nextValues);
    }
}
