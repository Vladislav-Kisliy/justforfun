package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.Handler;
import vladislav.kisliy.jff.nio.handler.TransmogrofyChannelHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class SingleThreadedNonBlockPoolingServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssch = ServerSocketChannel.open();
        ssch.bind(new InetSocketAddress(8080));
        ssch.configureBlocking(false);

        Handler<SocketChannel> handler = new TransmogrofyChannelHandler();
        Collection<SocketChannel> sockets = new ArrayList<>();

        while (true) {
            SocketChannel ch = ssch.accept(); // almost always null
            if (ch != null) {
                sockets.add(ch);
                System.out.println("Connected to " + ch);
                ch.configureBlocking(false);
            }

            for (SocketChannel socket : sockets) {
                if (socket.isConnected()) {
                    handler.handle(socket);
                }
            }
            sockets.removeIf(socket -> !socket.isConnected());
        }
    }

}
