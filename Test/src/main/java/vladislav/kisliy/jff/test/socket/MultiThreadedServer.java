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
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedServer implements Runnable {

    protected final int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;
    protected Thread runningThread = null;
    private final ExecutorService pool;

    public MultiThreadedServer(int port) {
        this.serverPort = port;
        pool = Executors.newFixedThreadPool(10);
    }

    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
//            new Thread(
//                    new WorkerRunnable(
//                            clientSocket, "Multithreaded Server")
//            ).start();

            pool.execute(new WorkerRunnable(clientSocket, "Thread Pooled Server"));
        }
        System.out.println("Server Stopped.");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
        shutdownAndAwaitTermination();
    }

    private void shutdownAndAwaitTermination() {
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
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

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

    public class WorkerRunnable implements Runnable {

        protected Socket clientSocket = null;
        protected String serverText = null;

        public WorkerRunnable(Socket clientSocket, String serverText) {
            this.clientSocket = clientSocket;
            this.serverText = serverText;
        }

        @Override
        public void run() {
            long time = 0l;
            try (InputStream input = clientSocket.getInputStream();
                    OutputStream output = clientSocket.getOutputStream()) {

                time = System.currentTimeMillis();
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                String s = br.readLine();
                System.out.println("Get from client =" + s);
                output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: "
                        + this.serverText + " - "
                        + time
                        + " - "
                        + clientSocket.getInetAddress()
                        + "\n\n").getBytes());
                output.flush();
            } catch (IOException e) {
                //report exception somewhere.
                e.printStackTrace();
            }
            System.out.println("Request processed: " + time);
        }
    }

    public static void main(String args[]) throws IOException {
        MultiThreadedServer server = new MultiThreadedServer(4456);
        System.out.println("Starting Server");
        new Thread(server).start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String :");
        String s = br.readLine();
        System.out.println("Exit. line =" + s);
        System.out.println("Stopping Server");
        server.stop();
    }
}
