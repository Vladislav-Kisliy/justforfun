package vladislav.kisliy.jff.test.codeforces;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class MagicPresent {

    public static final int FAILURE = -1;
    private static Envelope postCard;

    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        MagicPresent magicPresent = new MagicPresent();
        Envelope[] envelops = magicPresent.readEnvelops(in);
        Envelope[] envelopeList = magicPresent.calculatePath(envelops);
        System.out.println(envelopeList.length);
        for (Envelope envelope : envelopeList) {
            System.out.print(envelope.number);
            System.out.print(" ");
        }
    }

    public Envelope[] calculatePath(Envelope[] envelops) {
        Map<Integer, Integer> connections = new HashMap<>();
        int[] dp = new int[envelops.length];
        int maxPath = 0;
        int tailPosition = 0;
        for (int i = 1; i < envelops.length; i++) {
            Envelope envelope = envelops[i];
            if (biggerThan(envelope, postCard)) {
                for (int j = 0; i > j; j++) {
                    Envelope nextEnvelope = envelops[j];
                    if (biggerThan(envelope, nextEnvelope)) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            connections.put(i, j);
                        }
                    }
                }
                if (maxPath < dp[i]) {
                    maxPath = dp[i];
                    tailPosition = i;
                }
            }
        }

        Deque<Envelope> stack = new LinkedList<>();
        Envelope[] result = new Envelope[maxPath];
        if (maxPath != 0) {
            int stepPosition = tailPosition;
            while (connections.containsKey(stepPosition)) {
                stack.push(envelops[stepPosition]);
                stepPosition = connections.get(stepPosition);
            }
        }

        int i = 0;
        for (Envelope envelope : stack) {
            result[i] = envelope;
            i++;
        }

        return result;
    }

    public static class Envelope implements Comparable<Envelope> {
        final int width;
        final int height;
        final int number;

        public Envelope(int width, int height, int number) {
            this.width = width;
            this.height = height;
            this.number = number;
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
            if (this.width == envelope.width) {
                return Integer.compare(this.height, envelope.height);
            }
            return Integer.compare(this.width, envelope.width);
        }
    }

    public static boolean biggerThan(Envelope root, Envelope envelope) {
        return (root.height > envelope.height) && (root.width > envelope.width);
    }

    public Envelope[] readEnvelops(InputStream in) {
        Reader scanner = new Reader(in);

        int taskNum = scanner.nextInt();
        int postCardWidth = scanner.nextInt();
        int postCardHeight = scanner.nextInt();
        Envelope[] result = new Envelope[taskNum + 1];
        result[0] = new Envelope(postCardWidth, postCardHeight, 0);
        postCard = result[0];
        for (int i = 1; i <= taskNum; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            result[i] = new Envelope(width, height, i);
        }
        Arrays.sort(result);
        return result;
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
