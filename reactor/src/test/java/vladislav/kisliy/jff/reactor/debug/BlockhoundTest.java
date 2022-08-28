package vladislav.kisliy.jff.reactor.debug;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlockhoundTest {

    private final static AtomicBoolean BLOCKHOUND = new AtomicBoolean();

    @BeforeEach
    public void before() {
//        BLOCKHOUND.set(true);
//        List<BlockHoundIntegration> integrations = new ArrayList<>();
//        ServiceLoader<BlockHoundIntegration> services = ServiceLoader.load(BlockHoundIntegration.class);
//        services.forEach(integrations::add);
//        integrations.add(builder -> builder.blockingMethodCallback(blockingMethod -> {
//            if (BLOCKHOUND.get()) {
//                throw new BlockingCallError(blockingMethod.toString());
//            }
//        }));
//        BlockHound.install(integrations.toArray(new BlockHoundIntegration[0]));
        BlockHound.install();
    }

    @AfterEach
    public void after() {
        BLOCKHOUND.set(false);
    }

    @Test
    public void ok() {
        StepVerifier.create(buildBlockingMono().subscribeOn(Schedulers.boundedElastic()))
                .expectNext(1L)
                .verifyComplete();
    }

    @Test
    public void notOk() {
        StepVerifier.create(buildBlockingMono().subscribeOn(Schedulers.parallel()))
                .expectErrorMatches(e -> e instanceof BlockingCallError);
    }

    Mono<Long> buildBlockingMono() {
        return Mono.just(1L).doOnNext(it -> block());
    }

    @SneakyThrows
    void block() {
        Thread.sleep(1000);
    }

    private static class BlockingCallError extends Error {
        BlockingCallError(String msg) {
            super(msg);
        }
    }
}
