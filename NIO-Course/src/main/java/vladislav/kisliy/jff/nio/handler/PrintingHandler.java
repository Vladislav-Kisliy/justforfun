package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class PrintingHandler<S> extends DecoratorHandler<S> {

    public PrintingHandler(Handler<S> wrapperHandler) {
        super(wrapperHandler);
    }

    @Override
    public void handle(S s) throws IOException {
        System.out.println("Connected with " + s);
        try {
            super.handle(s);
        } finally {
            System.out.println("Disconnected from " + s);
        }
    }
}
