package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class UncheckedIOExcHandler<S> extends DecoratorHandler<S> {

    public UncheckedIOExcHandler(Handler<S> wrapperHandler) {
        super(wrapperHandler);
    }

    @Override
    public void handle(S s) {
        try {
            super.handle(s);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
