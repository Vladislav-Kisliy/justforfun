package vladislav.kisliy.jff.nio.handler;

import vladislav.kisliy.jff.nio.util.Util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class TransmogrofyChannelHandler implements Handler<SocketChannel> {

    @Override
    public void handle(SocketChannel sch) throws IOException {
        ByteBuffer buf = ByteBuffer.allocateDirect(80);
        int read = sch.read(buf);
        if (read == -1) {
            sch.close();
            return;
        }
        if (read > 0) {
            Util.transmografy(buf);
            while (buf.hasRemaining()) {
                sch.write(buf);
            }
        }
    }
}
