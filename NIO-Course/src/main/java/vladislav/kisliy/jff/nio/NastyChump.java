package vladislav.kisliy.jff.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class NastyChump {

    public static void main(String[] args) throws InterruptedException, IOException {
        Socket[] sockets = new Socket[3000];
        for (int i = 0; i < sockets.length; i++) {
            sockets[i] = new Socket("localhost", 8080);
        }

        Thread.sleep(100_000);
    }
}
