package vladislav.kisliy.jff.reactor.debug;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static vladislav.kisliy.jff.reactor.debug.HooksOnOperatorDebugTest.stackTraceToString;

public class CheckpointTest {

    @Test
    public void checkpoint() {
        AtomicReference<String> stackTrace = new AtomicReference<>();
        Flux<Object> checkpoint = Flux.error(new IllegalArgumentException("Oops!"))
                .checkpoint()
                .delayElements(Duration.ofMillis(1));

        StepVerifier.create(checkpoint)
                .expectErrorMatches(ex -> {
                    stackTrace.set(stackTraceToString(ex));
                    return ex instanceof IllegalArgumentException;
                })
                .verify();
        assertTrue(stackTrace.get().contains("Error has been observed at the following site(s):"));
    }

}
