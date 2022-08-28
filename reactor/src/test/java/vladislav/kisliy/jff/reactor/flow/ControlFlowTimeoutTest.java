package vladislav.kisliy.jff.reactor.flow;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class ControlFlowTimeoutTest {

    @Test
    public void timeout() throws Exception {
        Flux<Integer> ids = Flux.just(1, 2, 3)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofMillis(500))
                .onErrorResume(this::given);

        StepVerifier.create(ids)
                .expectNext(0)
                .verifyComplete();
    }

    private Flux<Integer> given(Throwable t) {
        assertTrue("this exception should be a " + TimeoutException.class.getName(),
                t instanceof TimeoutException);
        return Flux.just(0);
    }
}
