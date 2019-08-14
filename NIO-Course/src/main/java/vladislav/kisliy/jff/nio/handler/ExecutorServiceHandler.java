package vladislav.kisliy.jff.nio.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class ExecutorServiceHandler<S> extends UncheckedIOExcHandler<S> {

    private final ExecutorService executorService;
    private Thread.UncaughtExceptionHandler exceptionHandler;

    public ExecutorServiceHandler(Handler<S> wrapperHandler, ExecutorService executorService,
                                  Thread.UncaughtExceptionHandler exceptionHandler) {
        super(wrapperHandler);
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void handle(S s) {
        executorService.submit(new FutureTask<>(() -> {
            super.handle(s);
            return null;
        }) {
            @Override
            protected void setException(Throwable t) {
                exceptionHandler.uncaughtException(Thread.currentThread(), t);
            }
        });
    }
}
