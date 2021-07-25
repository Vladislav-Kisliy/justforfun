package vladislav.kisliy.jff.test.sto;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakRef {

    public static void main(String[] args) throws InterruptedException {
        Map<String, int[]> hm = new WeakHashMap<>();
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            i++;
            String key = new String(new Integer(i).toString());
            System.out.println(String.format("add new element %d", i));
            // 1K * 1M
            hm.put(key, new int[1024 * 100_000]);
            key = null;
            //System.gc();
        }
    }
}
