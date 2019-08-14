package vladislav.kisliy.jff.nio.handler;

import vladislav.kisliy.jff.nio.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class TransmogrofyHandler implements Handler<Socket> {
    @Override
    public void handle(Socket s) throws IOException {
        try (s; // Java 9 only
             InputStream in = s.getInputStream();
             OutputStream out = s.getOutputStream()) {
            // test mode
//            in.transferTo(out);
            int data;
            while ((data = in.read()) != -1) {
                out.write(Util.transmografy(data));
            }
        } catch (IOException ex) {
//                throw new UncheckedIOException(ex);
            ex.printStackTrace();
        } finally {
            System.out.println("Disconnected from " + s);
        }
    }
}
