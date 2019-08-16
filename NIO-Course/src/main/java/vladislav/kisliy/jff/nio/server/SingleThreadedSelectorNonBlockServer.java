package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.AcceptHandler;
import vladislav.kisliy.jff.nio.handler.Handler;
import vladislav.kisliy.jff.nio.handler.ReadHandler;
import vladislav.kisliy.jff.nio.handler.WriteHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class SingleThreadedSelectorNonBlockServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssch = ServerSocketChannel.open();
        ssch.bind(new InetSocketAddress(8080));
        ssch.configureBlocking(false);

        Selector selector = Selector.open();
        ssch.register(selector, SelectionKey.OP_ACCEPT);

        Map<SocketChannel, Queue<ByteBuffer>> pendindData = new HashMap<>();
        Handler<SelectionKey> acceptHandler = new AcceptHandler(pendindData);
        Handler<SelectionKey> readHandler = new ReadHandler(pendindData);
        Handler<SelectionKey> writeHandler = new WriteHandler(pendindData);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            for (Iterator<SelectionKey> it = keys.iterator(); it.hasNext(); ) {
                SelectionKey key = it.next();
                it.remove();
                if (key.isValid()) {
                    if (key.isAcceptable()) {
                        acceptHandler.handle(key);
                    } else if (key.isReadable()) {
                        readHandler.handle(key);
                    } else if (key.isWritable()) {
                        writeHandler.handle(key);
                    }
                }
            }
        }
    }

}
