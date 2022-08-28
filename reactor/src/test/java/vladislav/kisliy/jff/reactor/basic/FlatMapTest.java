package vladislav.kisliy.jff.reactor.basic;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class FlatMapTest {

    @Test
    public void flatMap() {
        Flux<Integer> data = Flux
                .just(new Pair(1, 300), new Pair(2, 200), new Pair(3, 100))
                .flatMap(id -> delayReplyFor(id.id, id.delay));

        StepVerifier
                .create(data)
                .expectNext(3, 2, 1)
                .verifyComplete();
    }

    @Test
    public void flatMap01() {
        Flux<String> data = Flux
                .just(new Pair(1, 300), new Pair(2, 200), new Pair(3, 100))
//                        .flatMap(id -> Flux.just("1", "2", "3", id.toString()));
                .flatMap(id -> replyWithString(id.id, id.delay));

        StepVerifier
                .create(data)
                .expectNext("1", "300", "2", "200", "3", "100")
                .verifyComplete();
    }

    @Test
    public void concatMap() {
        Flux<Integer> data = Flux
                .just(new Pair(1, 300), new Pair(2, 200), new Pair(3, 100))
                .concatMap(id -> delayReplyFor(id.id, id.delay));

        StepVerifier
                .create(data)
                .expectNext(1, 2, 3)
                .verifyComplete();
    }

    @Test
    public void switchMapWithLookaheads() {
        Flux<String> source = Flux
                .just("re", "rea", "reac", "react", "reactive")
                .delayElements(Duration.ofMillis(100))
                .switchMap(this::lookup);
        StepVerifier.create(source).expectNext("reactive -> reactive").verifyComplete();
    }

    @Test
    public void monoAndFlux() {
        Flux<String> success = Flux.just("Orange", "Apple", "Banana", "Grape", "Strawberry");
        Flux<String> erroneous = Flux.just("Banana", "Grape").doOnEach(System.out::println).delayElements(Duration.ofMillis(1000));

        Mono<Set<String>> erroneousSet = erroneous.collect(Collectors.toSet());
//        Mono<Set<String>> erroneousSet = erroneous.collect(Collectors.toSet()).cache();
        Flux<String> filtered = success.filterWhen(v -> erroneousSet.map(s -> !s.contains(v)));

        StepVerifier.create(filtered).expectNext("Orange", "Apple", "Strawberry").verifyComplete();
    }


    private Flux<Integer> delayReplyFor(Integer i, long delay) {
        return Flux.just(i)
                .delayElements(Duration.ofMillis(delay));
    }

    private Flux<String> replyWithString(Integer i, long delay) {
        return Flux.just(i.toString(), String.valueOf(delay));
    }

    private Flux<String> lookup(String word) {
        return Flux.just(word + " -> reactive")//
                .delayElements(Duration.ofMillis(500));
    }

    @AllArgsConstructor
    static class Pair {
        private int id;
        private long delay;
    }
}

