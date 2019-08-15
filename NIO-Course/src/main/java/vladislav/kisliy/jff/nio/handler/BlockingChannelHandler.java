package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 15.08.19.
 */
public class BlockingChannelHandler extends DecoratorHandler<SocketChannel> {

    public BlockingChannelHandler(Handler<SocketChannel> wrapperHandler) {
        super(wrapperHandler);
    }

    @Override
    public void handle(SocketChannel sc) throws IOException {
        while (sc.isConnected()) {
            super.handle(sc);
        }
    }
}
