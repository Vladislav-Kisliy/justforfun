package vladislav.kisliy.jff.reactor.flow;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class ControlFlowRetryTest {

    @Test
    public void retry() {
        AtomicBoolean errored = new AtomicBoolean();
        Flux<String> producer = Flux.create(sink -> {
            if (errored.get()) {
                log.info("we've already errored so here's the value");
                sink.next("hello");
            } else {
                errored.set(true);
                sink.error(new RuntimeException("Nope!"));
                log.info("returning a " + RuntimeException.class.getName() + "!");
            }
            sink.complete();
        });
        Flux<String> retryOnError = producer.retry();

        StepVerifier.create(retryOnError)
                .expectNext("hello")
                .verifyComplete();
    }

}
