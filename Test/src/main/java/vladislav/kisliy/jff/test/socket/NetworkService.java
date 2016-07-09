/*
 * Copyright (C) 2016 vlad
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vlad
 */
public class NetworkService implements Runnable {

    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize)
            throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() { // run the service
        try {
            for (;;) {
                pool.execute(new Handler(serverSocket.accept()));
            }
        } catch (IOException ex) {
            pool.shutdown();
        }
    }

    public void shutdownAndAwaitTermination() {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
    public ExecutorService getPool() {
        return pool;
    }
    
    public static void main(String args[]) throws IOException {
        NetworkService networkService = new NetworkService(8090, 10);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String :");
        String s = br.readLine();
        System.out.println("Exit. line ="+s);
        networkService.shutdownAndAwaitTermination();
    }
}

class Handler implements Runnable {

    private final Socket socket;
    private final String serverText = "** SOME TEXT **";

    Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        long time = 0l;
        System.out.println("Handler started");
        try (InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream()) {
            time = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            System.out.println("Input line =" + br.readLine());
            output.write(("HTTP/1.1 200 OK\n\nNetworkService: "
                    + this.serverText + " - "
                    + time
                    + "").getBytes());
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
        System.out.println("Request processed: " + time);
    }
}
