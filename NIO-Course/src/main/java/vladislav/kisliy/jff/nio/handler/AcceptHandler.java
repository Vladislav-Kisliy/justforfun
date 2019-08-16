package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 16.08.19.
 */
public class AcceptHandler implements Handler<SelectionKey> {

    private final Map<SocketChannel, Queue<ByteBuffer>> pendindData;

    public AcceptHandler(Map<SocketChannel, Queue<ByteBuffer>> pendindData) {
        this.pendindData = pendindData;
    }

    @Override
    public void handle(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel ssch = (ServerSocketChannel) selectionKey.channel();
        SocketChannel ch = ssch.accept(); // never null
        System.out.println("Connected to " + ssch);

        pendindData.put(ch, new ArrayDeque<>());

        ch.configureBlocking(false);
        ch.register(selectionKey.selector(), SelectionKey.OP_READ);
    }
}
