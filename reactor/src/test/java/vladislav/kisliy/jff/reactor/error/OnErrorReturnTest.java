package vladislav.kisliy.jff.reactor.error;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class OnErrorReturnTest {
    private final Flux<Integer> resultsInError = Flux.just(1, 2, 3).flatMap(counter -> {
        if (counter == 3) {
            return Flux.error(new IllegalArgumentException("Oops!"));
        } else {
            return Flux.just(counter);
        }
    });

    @Test
    public void onErrorReturn() {
        Flux<Integer> integerFlux = resultsInError.onErrorReturn(0);
        StepVerifier.create(integerFlux).expectNext(1, 2, 0).verifyComplete();
    }
}
