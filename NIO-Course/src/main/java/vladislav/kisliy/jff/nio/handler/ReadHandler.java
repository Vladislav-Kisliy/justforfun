package vladislav.kisliy.jff.nio.handler;

import vladislav.kisliy.jff.nio.util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 16.08.19.
 */
public class ReadHandler implements Handler<SelectionKey> {

    private final Map<SocketChannel, Queue<ByteBuffer>> pendindData;

    public ReadHandler(Map<SocketChannel, Queue<ByteBuffer>> pendindData) {
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
            System.out.println("Disconnected from " + ch + " (in read)");
            return;
        }
        if (read > 0) {
            Util.transmografy(buf);
            pendindData.get(ch).add(buf);
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }
}
