package vladislav.kisliy.jff.reactor.flow;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.StringJoiner;

public class ControlFlowZipTest {

    @Test
    public void zip() {
        Flux<Integer> first = Flux.just(1, 2, 3);
        Flux<String> second = Flux.just("a", "b", "c")
                .delayElements(Duration.ofMillis(2));
        Flux<String> zip = Flux.zip(first, second)
                .map(tuple -> from(tuple.getT1(), tuple.getT2()));
        StepVerifier.create(zip).expectNext("1:a", "2:b", "3:c").verifyComplete();
    }

    @Test
    public void zip1() {
        Flux<Integer> first = Flux.just(1, 2, 3);
        Flux<String> second = Flux.just("a", "b", "c")
                .delayElements(Duration.ofMillis(2));

        Flux<String> zip = first.zipWith(second)
                .map(tuple -> from(tuple.getT1(), tuple.getT2()));
        StepVerifier.create(zip).expectNext("1:a", "2:b", "3:c").verifyComplete();
    }

    @Test
    public void zip2() {
        StringJoiner elements = new StringJoiner(",");
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .map(integer -> Mono.error(IllegalArgumentException::new))
                .zipWith(Flux.range(0, Integer.MAX_VALUE),
                        (one, two) -> {
                            System.out.println("ZIP #");
                            return String.format("First Flux: %d, Second Flux: %d", one, two);
                        })
                .subscribe(elements::add);

        System.out.println("Elements =" + elements);
    }

    private String from(Integer i, String s) {
        return i + ":" + s;
    }
}
