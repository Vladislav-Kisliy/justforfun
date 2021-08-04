package vladislav.kisliy.jff.test.codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class MagicPresent {

    public static final int FAILURE = -1;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        MagicPresent magicPresent = new MagicPresent();
        List<Envelope> envelops = magicPresent.readEnvelops(in);
        Envelope[] envelopeList = magicPresent.calculatePath(envelops);
//        System.out.println("List =" + envelopeList);
        System.out.println(envelopeList.length);
        for (Envelope envelope : envelopeList) {
            System.out.print(envelope.number);
            System.out.print(" ");
        }
    }

    public Envelope[] calculatePath(List<Envelope> envelops) {
        // small -> big
        List<Envelope> firstLine = new ArrayList<>();

        if (!envelops.isEmpty()) {
            Envelope envelope = envelops.get(0);
            firstLine.add(envelope);
            for (int i = 1; i < envelops.size(); i++) {
                Envelope nextEnvelope = envelops.get(i);
                if (addWrap(envelope, nextEnvelope) == FAILURE) {
                    firstLine.add(nextEnvelope);
                }
            }
        }

//        System.out.println("envelops after adding=" + firstLine.size());
//        System.out.println("envelops after adding=" + firstLine);
        for (int i = 1; i < firstLine.size(); i++) {
            Envelope envelope = firstLine.get(i);
            for (int j = i + 1; j < firstLine.size(); j++) {
                Envelope nextEnvelope = firstLine.get(j);
                addWrap(envelope, nextEnvelope);
            }
        }
        envelops.removeAll(firstLine);

        for (int i = 1; i < firstLine.size(); i++) {
            Envelope envelope = firstLine.get(i);
            for (Envelope nextEnvelope : envelops) {
                addWrap(envelope, nextEnvelope);
            }
        }

        Envelope[] array = new Envelope[0];
        Envelope result = null;
        int maxValue = -1;
        for (Envelope env : firstLine) {
            validateMaxDepth(env);
            if (maxValue < env.maxDepth) {
                maxValue = env.maxDepth;
                result = env;
//                System.out.println("Choose max =" + env + ", max=" + maxValue);
            }
        }
        if (result != null) {
            array = getLongestPath(result);
        }
//        System.out.println("envelops result=" + Arrays.toString(array));

        return array;
    }

    public List<Envelope> getEnvelopeList(NavigableMap<Integer, NavigableSet<Envelope>> result) {
        List<Envelope> nodes = new ArrayList<>();
        for (Map.Entry<Integer, NavigableSet<Envelope>> entry : result.entrySet()) {
            for (Envelope envelop : entry.getValue()) {
                nodes.add(envelop);
            }
        }
//        System.out.println("getEnvelopeList size=" + nodes.size());
//        System.out.println("getEnvelopeList =" + nodes);
        return nodes;
    }

    public static int getKey(Envelope envelope) {
        return envelope.width;
    }

    public static class Envelope implements Comparable<Envelope> {
        final int width;
        final int height;
        final int number;
        int maxDepth = 1;
        List<Envelope> adj = new ArrayList<>();
        Envelope tail = null;

        public Envelope(int width, int height, int number) {
            this.width = width;
            this.height = height;
            this.number = number;
        }

        public boolean biggerThan(Envelope envelope) {
            if (envelope == null) return false;
            return (this.height > envelope.height) && (this.width > envelope.width);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Envelope envelope = (Envelope) o;
            return number == envelope.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return "Envelope{" +
                    "width=" + width +
                    ", height=" + height +
                    ", number=" + number +
                    '}';
        }

        @Override
        public int compareTo(Envelope envelope) {
            return Integer.compare(this.height, envelope.height);
        }
    }

    public static int addWrap(Envelope root, Envelope envelope) {
        int result = FAILURE;
        if (!root.adj.contains(envelope) && envelope.biggerThan(root)) {
            if (root.adj.isEmpty()) {
                root.adj.add(envelope);
                root.tail = envelope;
                root.maxDepth = envelope.maxDepth + 1;
                result = root.maxDepth;
            } else {
                List<Envelope> forAdd = new ArrayList<>();
                boolean maxDepthChanged = false;
                for (Envelope depEnvelope : root.adj) {
                    if (!depEnvelope.adj.contains(envelope)) {
                        result = addWrap(depEnvelope, envelope);
                        if (result == FAILURE) {
                            if (!forAdd.contains(envelope)) {
                                forAdd.add(envelope);
                                maxDepthChanged = true;
                            }
                        } else {
                            maxDepthChanged = true;
                        }
                    }
                }
                root.adj.addAll(forAdd);
                if (maxDepthChanged) {
                    for (Envelope depEnvelope : root.adj) {
                        if (root.maxDepth < depEnvelope.maxDepth + 1) {
                            root.tail = depEnvelope;
                            root.maxDepth = depEnvelope.maxDepth + 1;
                        }
                    }
                    result = root.maxDepth;
                }
            }
        }
        return result;
    }

    public static int validateMaxDepth(Envelope root) {
        int result = 1;
        if (root.tail != null) {
            result = validateMaxDepth(root.tail) + 1;
            root.maxDepth = result;
        }
        return result;
    }

    public Envelope[] getLongestPath(Envelope root) {
        Envelope[] result;
        if (root.tail == null) {
            result = new Envelope[]{root};
        } else {
            result = new Envelope[root.maxDepth];
            Envelope[] tailLongestPath = getLongestPath(root.tail);
            for (int i = 0; i < tailLongestPath.length; i++) {
                result[i + 1] = tailLongestPath[i];
            }
            result[0] = root;
        }
        return result;
    }

    public List<Envelope> readEnvelops(InputStream in) {
        Reader scanner = new Reader(in);

        int taskNum = scanner.nextInt();
        int postCardWidth = scanner.nextInt();
        int postCardHeight = scanner.nextInt();

        NavigableMap<Integer, NavigableSet<Envelope>> result = new TreeMap<>();
        int counter = 1;

        for (int i = 0; i < taskNum; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            if (postCardWidth < width && postCardHeight < height) {
                Envelope envelope = new Envelope(width, height, counter);
                int key = getKey(envelope);
                if (result.containsKey(key)) {
                    if (!result.get(key).contains(envelope)) {
                        result.get(key).add(envelope);
                    }
                } else {
                    NavigableSet<Envelope> envelops = new TreeSet<>();
                    envelops.add(envelope);
                    result.put(key, envelops);
                }
            }
            counter++;
        }
        return getEnvelopeList(result);
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(InputStream inputStream) {
            din = new DataInputStream(inputStream);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != FAILURE) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() {
            int ret = 0;
            try {
                byte c = read();
                while (c <= ' ') {
                    c = read();
                }
                boolean neg = (c == '-');
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                } while ((c = read()) >= '0' && c <= '9');

                if (neg)
                    return -ret;
            } catch (IOException e) {
                System.out.println("IOException =" + e.getMessage());
            }

            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == FAILURE)
                buffer[0] = FAILURE;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
