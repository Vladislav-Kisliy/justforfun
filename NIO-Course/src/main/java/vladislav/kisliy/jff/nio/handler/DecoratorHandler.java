package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public abstract  class DecoratorHandler<S> implements Handler<S> {
    private final Handler<S> wrapperHandler;

    public DecoratorHandler(Handler<S> wrapperHandler) {
        this.wrapperHandler = wrapperHandler;
    }

    @Override
    public void handle(S s) throws IOException {
        wrapperHandler.handle(s);
    }
}
