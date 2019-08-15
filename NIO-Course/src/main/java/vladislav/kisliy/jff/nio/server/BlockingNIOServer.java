package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.BlockingChannelHandler;
import vladislav.kisliy.jff.nio.handler.ExecutorServiceHandler;
import vladislav.kisliy.jff.nio.handler.Handler;
import vladislav.kisliy.jff.nio.handler.PrintingHandler;
import vladislav.kisliy.jff.nio.handler.TransmogrofyChannelHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class BlockingNIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssch = ServerSocketChannel.open();
        ssch.bind(new InetSocketAddress(8080));
        Handler<SocketChannel> handler = new ExecutorServiceHandler<>(
                new PrintingHandler<>(new BlockingChannelHandler(new TransmogrofyChannelHandler())),
                Executors.newFixedThreadPool(30));
        while (true) {
            SocketChannel ch = ssch.accept(); // never null
            handler.handle(ch);
        }
    }

}
