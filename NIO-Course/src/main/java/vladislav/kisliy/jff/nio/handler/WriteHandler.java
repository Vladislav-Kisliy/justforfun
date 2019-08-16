package vladislav.kisliy.jff.nio.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 16.08.19.
 */
public class WriteHandler implements Handler<SelectionKey> {

    private static final Queue EMPTY_QUEUE = new ArrayDeque();

    private final Map<SocketChannel, Queue<ByteBuffer>> pendindData;

    public WriteHandler(Map<SocketChannel, Queue<ByteBuffer>> pendindData) {
        this.pendindData = pendindData;
    }

    @Override
    public void handle(SelectionKey selectionKey) throws IOException {
        SocketChannel ch = (SocketChannel) selectionKey.channel();

        Queue<ByteBuffer> queue = pendindData.getOrDefault(ch, EMPTY_QUEUE);
        while (!queue.isEmpty()) {
            ByteBuffer buf = queue.peek();
            int written = ch.write(buf);
            if (written == -1) {
                ch.close();
                pendindData.remove(ch);
                System.out.println("Disconnected from " + ch + " (in write)");
                return;
            }
            if (buf.hasRemaining()) return;
            queue.remove();
        }
        selectionKey.interestOps(SelectionKey.OP_READ);
    }
}
