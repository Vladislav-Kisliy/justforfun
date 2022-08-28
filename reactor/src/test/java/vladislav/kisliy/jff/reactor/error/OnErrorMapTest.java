package vladislav.kisliy.jff.reactor.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnErrorMapTest {

    @Test
    public void onErrorMap() throws Exception {
        AtomicInteger counter = new AtomicInteger();
        Flux<Integer> resultsInError = Flux.error(new IllegalArgumentException("oops!"));
        Flux<Integer> errorHandlingStream = resultsInError
                .onErrorMap(IllegalArgumentException.class, ex -> new GenericException())
                .doOnError(GenericException.class, ge -> counter.incrementAndGet());

        StepVerifier.create(errorHandlingStream)
                .expectError()
                .verify();
        assertEquals(counter.get(), 1);
    }

    class GenericException extends RuntimeException {
    }

}
