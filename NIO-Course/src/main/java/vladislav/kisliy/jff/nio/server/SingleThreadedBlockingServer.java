package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.PrintingHandler;
import vladislav.kisliy.jff.nio.handler.TransmogrofyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        PrintingHandler<Socket> handler = new PrintingHandler<>(new TransmogrofyHandler());
        while (true) {
            Socket s = ss.accept(); //blocks, never null
            handler.handle(s);
        }
    }
}
