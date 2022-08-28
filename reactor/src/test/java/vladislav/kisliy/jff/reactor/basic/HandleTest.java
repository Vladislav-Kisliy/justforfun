package vladislav.kisliy.jff.reactor.basic;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class HandleTest {

    @Test
    public void handle() {
        StepVerifier
                .create(handle(5, 4))
                .expectNext(0, 1, 2, 3)
                .expectError(IllegalArgumentException.class)
                .verify();
        StepVerifier
                .create(handle(3, 3))
                .expectNext(0, 1, 2)
                .verifyComplete();
    }

    Flux<Integer> handle(int max, int numberToError) {
        return Flux
                .range(0, max)
                .handle((value, sink) -> {
                    List<Integer> upTo = IntStream.range(0, numberToError)
                            .boxed()
                            .collect(Collectors.toList());
                    if (upTo.contains(value)) {
                        sink.next(value);
                        return;
                    }
                    if (value == numberToError) {
                        sink.error(new IllegalArgumentException("No 4 for you!"));
                        return;
                    }
                    sink.complete();
                });
    }

}
