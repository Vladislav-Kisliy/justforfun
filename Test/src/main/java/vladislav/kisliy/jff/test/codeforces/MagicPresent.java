package vladislav.kisliy.jff.test.codeforces;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class MagicPresent {

    private static final String NEWLINE = System.getProperty("line.separator");

    public Envelope postCard;

    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        MagicPresent magicPresent = new MagicPresent();
        List<Envelope> envelops = magicPresent.readEnvelops(in);
        Envelope[] envelopeList = magicPresent.calculatePath(envelops, magicPresent.postCard);
//        System.out.println("List =" + envelopeList);
        System.out.println(envelopeList.length);
        for (Envelope envelope : envelopeList) {
            System.out.print(envelope.number);
            System.out.print(" ");
        }
    }

    public Envelope[] calculatePath(List<Envelope> envelops, Envelope postCard) {
        Graph graph = new Graph(envelops.size());
        // small -> big
        for (int i = 0; i < envelops.size(); i++) {
            Envelope envelope = envelops.get(i);
            graph.setEnvelope(i, envelope);
            for (int j = i + 1; j < envelops.size(); j++) {
                Envelope nextEnvelope = envelops.get(j);
                if (nextEnvelope.biggerThan(envelope)) {
                    graph.addEdge(i, j);
                } else {
                    if (i == 0 || i == 1) {
                        System.out.println("alternatives for " + i + ", next envl =" + nextEnvelope + ", envl=" + envelope);
                    }
                }
            }
        }

        System.out.println("envelops after adding=" + graph);

        Envelope[] result = new Envelope[0];
        int maxValue = 0;
        for (int i = 0; i < envelops.size(); i++) {
            DepthFirstSearch dfs = new DepthFirstSearch(graph, i);
            if (maxValue < dfs.longestPath.size()) {
                result = dfs.getLongestPath();
//                System.out.println("Set result =" + Arrays.toString(result) + ", i =" + i);
                maxValue = dfs.longestPath.size();
            }
        }

//        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 11);
//        System.out.println("getLongestPath 11=" + Arrays.toString(depthFirstSearch.getLongestPath()));
//        System.out.println("connected to 11=" + depthFirstSearch.count());
//        System.out.println("max length 11=" + depthFirstSearch.longestPath);

//        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 18);
//        System.out.println("getLongestPath 18=" + Arrays.toString(depthFirstSearch.getLongestPath()));
//        System.out.println("connected to 18=" + depthFirstSearch.count());
//        System.out.println("max length 18=" + depthFirstSearch.longestPath);

//
//        depthFirstSearch = new DepthFirstSearch(graph, 25);
//        System.out.println("connected to 25=" + depthFirstSearch.count());
//        System.out.println("max length 25=" + depthFirstSearch.longestPath);
//        System.out.println("getLongestPath 25=" + Arrays.toString(depthFirstSearch.getLongestPath()));
//
//        depthFirstSearch = new DepthFirstSearch(graph, 2);
//        System.out.println("connected to 2=" + depthFirstSearch.count());
//        System.out.println("max length 2=" + depthFirstSearch.longestPath);
//        System.out.println("connected to 4=" + new DepthFirstSearch(graph, 4).count());
//        System.out.println("");

        return result;
    }

    public List<Envelope> readEnvelops(InputStream in) {
        Reader scanner = new Reader(in);

        int taskNum = scanner.nextInt();
        postCard = new Envelope(scanner.nextInt(), scanner.nextInt(), 0);

        NavigableMap<Integer, NavigableSet<Envelope>> result = new TreeMap<>();
        int counter = 1;

        for (int i = 0; i < taskNum; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            if (postCard.width < width && postCard.height < height) {
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

    public List<Envelope> getEnvelopeList(NavigableMap<Integer, NavigableSet<Envelope>> result) {
        List<Envelope> nodes = new ArrayList<>();
        for (Map.Entry<Integer, NavigableSet<Envelope>> entry : result.entrySet()) {
            for (Envelope envelop : entry.getValue()) {
                nodes.add(envelop);
            }
        }
        return nodes;
    }

    public static int getKey(Envelope envelope) {
        return envelope.width;
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
            while ((c = read()) != -1) {
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
            if (bytesRead == -1)
                buffer[0] = -1;
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

    public static class Envelope implements Comparable<Envelope> {
        final int width;
        final int height;
        final int number;

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

    public static class Graph {
        public final int V;
        private final Envelope[] envelopes;
        private int E;
        private LinkedList<Integer>[] adj;

        public Graph(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
            this.V = V;
            this.envelopes = new Envelope[V];
            this.E = 0;
            adj = (LinkedList<Integer>[]) new LinkedList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new LinkedList<>();
            }
        }

        public int V() {
            return V;
        }

        public void setEnvelope(int v, Envelope envelope) {
            validateVertex(v);
            envelopes[v] = envelope;
        }

        public void addEdge(int v, int w) {
            validateVertex(v);
            validateVertex(w);
            E++;
            adj[v].add(w);
        }

        public Collection<Integer> adj(int v) {
            validateVertex(v);
            return adj[v];
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(V + " vertices, " + E + " edges " + NEWLINE);
            for (int v = 0; v < V; v++) {
                s.append(v + "(" + envelopes[v] + "): ");
                for (int w : adj[v]) {
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

        private void validateVertex(int v) {
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public static class DepthFirstSearch {
        private final Graph graph;
        private final int startVertex;
        private final Deque<Integer> stack = new LinkedList<>();
        private boolean[] marked;    // marked[v] = is there an s-v path?
        private int count;           // number of vertices connected to s
        private List<Integer> longestPath = new ArrayList<>();

        public DepthFirstSearch(Graph G, int s) {
            this.graph = G;
            this.startVertex = s;
            marked = new boolean[graph.V()];
            validateVertex(startVertex);
            longestPath.add(startVertex);
            stack.push(startVertex);
            dfs(startVertex);
        }


        public int count() {
            return count;
        }

        public Envelope[] getLongestPath() {
//            dfs(startVertex);
            Envelope[] result;
            if (longestPath.isEmpty()) {
                result = new Envelope[]{graph.envelopes[startVertex]};
            } else {
                result = new Envelope[longestPath.size()];
                for (int i = 0; i < longestPath.size(); i++) {
                    result[i] = graph.envelopes[longestPath.get(i)];
                }
            }
            return result;
        }

        // depth first search from v
        private void dfs(int v) {
            count++;
            marked[v] = true;

//            System.out.println("marked =" + Arrays.toString(marked));
//            System.out.println("stack #1=" + stack);

            for (int w : graph.adj(v)) {
                if (v == 18) {
                    System.out.println("v=18. for v =" + v + ", w =" + w);
                }
                if (w == 18) {
                    System.out.println("w=18. for v =" + v + ", w =" + w);
                }
//                System.out.println("for v =" + v + ", w =" + w);
                if (!marked[w]) {
//                    System.out.println("stack #2=" + stack);
                    stack.addLast(w);
                    dfs(w);
                    if (stack.size() > longestPath.size()) {
//                        System.out.println("add stack=" + stack);
                        longestPath.clear();
                        longestPath.addAll(stack);
                    }
                    stack.pollLast();
//                    marked[w] = false;

                }
            }
            System.out.println("longestPath =" + longestPath);
        }

        private void validateVertex(int v) {
            int V = marked.length;
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
