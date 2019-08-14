package vladislav.kisliy.jff.nio.handler;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class ThreadedHandler<S> extends UncheckedIOExcHandler<S> {

    public ThreadedHandler(Handler<S> wrapperHandler) {
        super(wrapperHandler);
    }

    @Override
    public void handle(S s) {
        new Thread(() -> super.handle(s)).start();
    }
}
