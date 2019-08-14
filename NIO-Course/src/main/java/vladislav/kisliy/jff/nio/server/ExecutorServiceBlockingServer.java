package vladislav.kisliy.jff.nio.server;

import vladislav.kisliy.jff.nio.handler.ExecutorServiceHandler;
import vladislav.kisliy.jff.nio.handler.Handler;
import vladislav.kisliy.jff.nio.handler.PrintingHandler;
import vladislav.kisliy.jff.nio.handler.TransmogrofyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class ExecutorServiceBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Handler<Socket> handler = new ExecutorServiceHandler<>(new PrintingHandler<>(new TransmogrofyHandler()),
                Executors.newFixedThreadPool(30),
                (t, e) -> System.out.println("thread: " + t + ", err: " + e));
        while (true) {
            Socket s = ss.accept(); //blocks, never null
            handler.handle(s);
        }
    }

}
