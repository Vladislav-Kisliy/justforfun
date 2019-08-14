package vladislav.kisliy.jff.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class SingleThreadedBlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        while (true) {
            Socket s = ss.accept(); //blocks, never null
            handle(s);
        }
    }

    private static void handle(Socket s) {
        System.out.println("Connected with " + s);
        try (s;
             InputStream in = s.getInputStream();
             OutputStream out = s.getOutputStream()) {
            // test mode
//            in.transferTo(out);
            int data;
            while ((data = in.read()) != -1) {
                out.write(transmografy(data));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Disconnected from " + s);
        }
    }

    private static int transmografy(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
