package vladislav.kisliy.jff.reactor.debug;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HooksOnOperatorDebugTest {

    @Test
    public void onOperatorDebug() {
        Hooks.onOperatorDebug();
        AtomicReference<String> stackTrace = new AtomicReference<>();
        Flux<Object> errorFlux = Flux.error(new IllegalArgumentException("Oops!"))
                .checkpoint()
                .delayElements(Duration.ofMillis(1));

        StepVerifier.create(errorFlux)
                .expectErrorMatches(ex -> {
                    stackTrace.set(stackTraceToString(ex));
                    return ex instanceof IllegalArgumentException;
                })
                .verify();
        assertTrue(stackTrace.get().contains("Flux.error ⇢ at " + HooksOnOperatorDebugTest.class.getName()));
    }

    public static String stackTraceToString(Throwable throwable) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        } catch (Exception ioEx) {
            throw new RuntimeException(ioEx);
        }
    }
}
