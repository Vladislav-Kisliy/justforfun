package vladislav.kisliy.jff.nio.handler;

import vladislav.kisliy.jff.nio.util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 18.08.19.
 */
public class PooledReadHandler implements Handler<SelectionKey> {
    private final ExecutorService pool;
    private final Queue<Runnable> selectorActions;
    private final Map<SocketChannel, Queue<ByteBuffer>> pendindData;

    public PooledReadHandler(ExecutorService pool, Queue<Runnable> selectorActions, Map<SocketChannel,
            Queue<ByteBuffer>> pendindData) {
        this.pool = pool;
        this.selectorActions = selectorActions;
        this.pendindData = pendindData;
    }

    @Override
    public void handle(SelectionKey selectionKey) throws IOException {
        SocketChannel ch = (SocketChannel) selectionKey.channel();
        ByteBuffer buf = ByteBuffer.allocateDirect(80);
        int read = ch.read(buf);
        if (read == -1) {
            pendindData.remove(ch);
            ch.close();
            System.out.println("Disconnected from " + ch + " (in pooled read)");
            return;
        }
        if (read > 0) {
            pool.submit(() -> {
                Util.transmografy(buf);
                pendindData.get(ch).add(buf);
                selectorActions.add(() -> selectionKey.interestOps(SelectionKey.OP_WRITE));
                selectionKey.selector().wakeup();
            });


        }
    }
}
