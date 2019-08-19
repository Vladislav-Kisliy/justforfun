package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.AcceptHandler;
import vladislav.kisliy.jff.nio.handler.Handler;
import vladislav.kisliy.jff.nio.handler.PooledReadHandler;
import vladislav.kisliy.jff.nio.handler.ReadHandler;
import vladislav.kisliy.jff.nio.handler.WriteHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class SelectorWithWorkPoolNonBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssch = ServerSocketChannel.open();
        ssch.bind(new InetSocketAddress(8080));
        ssch.configureBlocking(false);

        Selector selector = Selector.open();
        ssch.register(selector, SelectionKey.OP_ACCEPT);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        Map<SocketChannel, Queue<ByteBuffer>> pendindData = new ConcurrentHashMap<>();
        Queue<Runnable> selectorActions = new ConcurrentLinkedQueue<>();

        Handler<SelectionKey> acceptHandler = new AcceptHandler(pendindData);
        Handler<SelectionKey> readHandler = new PooledReadHandler(pool, selectorActions, pendindData);
        Handler<SelectionKey> writeHandler = new WriteHandler(pendindData);

        while (true) {
            selector.select();
            processSelectorActions(selectorActions);
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

    private static void processSelectorActions(Queue<Runnable> selectorActions) {
        Runnable actions;
        while ((actions = selectorActions.poll()) != null) {
            actions.run();
        }
    }

}
