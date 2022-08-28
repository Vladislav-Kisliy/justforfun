package vladislav.kisliy.jff.reactor.basic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class SchedulersExecutorTest {

    private final AtomicInteger methodInvocationCounts = new AtomicInteger();
    private String rsb = "rsb";

    @BeforeEach
    public void before() {
        Schedulers.resetFactory();
        Schedulers.addExecutorServiceDecorator(this.rsb, (scheduler,
                                                          scheduledExecutorService) -> this.decorate(scheduledExecutorService));
    }

    @Test
    public void changeDefaultDecorator() {
        Flux<Integer> integerFlux = Flux.just(1).delayElements(Duration.ofMillis(1));
        StepVerifier.create(integerFlux).thenAwait(Duration.ofMillis(10))
                .expectNextCount(1).verifyComplete();
        assertEquals(1, this.methodInvocationCounts.get());
    }

    @Test
    public void excludeRunning() throws InterruptedException {
        Mono<Integer> quick = Mono.just(1)
                .log();
        fetch().subscribe();


        StepVerifier.create(quick)
                .expectNext(1)
                .verifyComplete();

        Thread.sleep(10000);
    }

    @AfterEach
    public void after() {
        Schedulers.resetFactory();
        Schedulers.removeExecutorServiceDecorator(this.rsb);
    }

    private ScheduledExecutorService decorate(ScheduledExecutorService executorService) {
        try {
            ProxyFactoryBean pfb = new ProxyFactoryBean();
            pfb.setProxyInterfaces(new Class[]{ScheduledExecutorService.class});
            pfb.addAdvice((MethodInterceptor) methodInvocation -> {
                String methodName = methodInvocation.getMethod().getName().toLowerCase();
                this.methodInvocationCounts.incrementAndGet();
                log.info("methodName: (" + methodName + ") incrementing...");
                return methodInvocation.proceed();
            });
            pfb.setSingleton(true);
            pfb.setTarget(executorService);
            return (ScheduledExecutorService) pfb.getObject();
        } catch (Exception e) {
            log.error("Error:", e);
        }
        return null;
    }

    @Test
    public void onScheduleHook() {
        AtomicInteger counter = new AtomicInteger();
        Schedulers.onScheduleHook("my hook", runnable -> () -> {
            String threadName = Thread.currentThread().getName();
            counter.incrementAndGet();
            log.info("before execution: " + threadName);
            runnable.run();
            log.info("after execution: " + threadName);
        });
        Flux<Integer> integerFlux = Flux.just(1, 2, 3).delayElements(Duration.ofMillis(1
                ))
                .subscribeOn(Schedulers.immediate());
        StepVerifier.create(integerFlux).expectNext(1, 2, 3).verifyComplete();
        assertEquals(3, counter.get(), "count should be 3");
    }

    @Test
    public void subscribeOnExecutor() {
        String rsbThreadName = SchedulersExecutorTest.class.getName();
        ConcurrentHashMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(5, runnable -> {
            Runnable wrapper = () -> {
                String key = Thread.currentThread().getName();
                AtomicInteger result = map.computeIfAbsent(key, s -> new AtomicInteger());
                result.incrementAndGet();
                runnable.run();
            };
            return new Thread(wrapper, rsbThreadName);
        });
        Scheduler scheduler = Schedulers.fromExecutor(executor);
        Mono<Integer> integerFlux = Mono.just(1).subscribeOn(scheduler)
                .doFinally(signal -> map.forEach((k, v) -> log.info(k + '=' + v)));
        StepVerifier.create(integerFlux).expectNextCount(1).verifyComplete();
        AtomicInteger atomicInteger = map.get(rsbThreadName);
        assertEquals(atomicInteger.get(), 1);
    }

    private Mono<String> fetch() {
        return Mono.fromCallable(() -> longBlock())
                .subscribeOn(Schedulers.boundedElastic());
    }

    @SneakyThrows
    String longBlock() {
        Thread.sleep(5000);
        System.out.println("Done.");
        return "1";
    }
}
