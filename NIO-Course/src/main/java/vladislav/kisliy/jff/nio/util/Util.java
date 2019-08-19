package vladislav.kisliy.jff.nio.util;

import java.nio.ByteBuffer;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class Util {

    public static int transmografy(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

    public static void transmografy(ByteBuffer buf) {
        System.out.println("Transmogrification done by "+Thread.currentThread());
        // pos = 0, limit = 80, capacity = 80
        // "hello\n", post = 6, limit = 80, cap = 80

        buf.flip(); // "hello\n", post = 0, limit = 6, cap = 80
        for (int i = 0; i < buf.limit(); i++) {
            buf.put(i, (byte) Util.transmografy(buf.get(i)));
        }
    }
}
