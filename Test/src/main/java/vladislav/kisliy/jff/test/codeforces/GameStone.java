package vladislav.kisliy.jff.test.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameStone {

    public static final int MAX_STONES = 2;

    public static void main(String[] args) throws Exception {
//        FastScanner scanner = new FastScanner(System.in);
//        InputStream in = new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/stones.txt");
        InputStream in = System.in;
        GameStone gameStone = new GameStone();
        int[][] stones = gameStone.readElements(in);
        for (int i = 0; i < stones.length; i++) {
            gameStone.calculateSteps(stones[i]);
        }

    }

    public int calculateSteps(int[] stones) {
        int stoneCounter = stones.length;
        int middle = (stoneCounter / 2) + 1;
        int leftCost = 0, rightCost = 0;
        int foundLeft = 0, foundRight = 0;


        for (int j = 0; j < middle; j++) {
            int isFound = foundElement(stones, stoneCounter, j);
            if (isFound > 0) {
                foundLeft += isFound;
                leftCost += j + 1 - leftCost;
            }
            isFound = foundElement(stones, stoneCounter, stoneCounter - j - 1);
            if (isFound > 0) {
                foundRight += isFound;
                rightCost += j + 1 - rightCost;
            }
        }

        int result = 0;
        if (foundLeft == MAX_STONES && foundRight == MAX_STONES) {
            result = leftCost;
        } else if (foundLeft == MAX_STONES) {
            result = leftCost;
        } else if (foundRight == MAX_STONES) {
            result = rightCost;
        } else {
            int twoWaysCost = leftCost + rightCost;
            int leftWayCost = leftCost + ((middle - leftCost) + (middle - rightCost) - 1);
            int rightWayCost = rightCost + ((middle - leftCost) + (middle - rightCost) - 1);

            result = Math.min(Math.min(twoWaysCost, leftWayCost), rightWayCost);
        }
        System.out.println(result);

        return result;
    }

    private int foundElement(int[] stones, int maxElement, int position) {
        int result = 0;
        int stone = stones[position];
        if (stone == 1 || stone == maxElement) {
            result++;
        }
        return result;
    }

    private int[][] readElements(InputStream in) {
        FastScanner scanner = new FastScanner(in);
        int taskNum = scanner.nextInt();
        int[][] result = new int[taskNum][1];
        for (int i = 0; i < taskNum; i++) {
            int stoneCounter = scanner.nextInt();
            int[] stones = new int[stoneCounter];
            for (int j = 0; j < stoneCounter; j++) {
                stones[j] = scanner.nextInt();
            }
            result[i] = stones;
//            System.out.println("Return result =" + Arrays.toString(result));
        }
        return result;
    }

    private void printArray(int[] array) {
        int pageCounter = 0;
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
            if (pageCounter == 40) {
                System.out.println();
                pageCounter = 0;
            }
            pageCounter++;
        }
        System.out.println("]");
    }

    public class FastScanner {

        private final BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream inputStream) {
            this.br = new BufferedReader(new InputStreamReader(inputStream));
            this.st = new StringTokenizer("");
        }

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    System.out.println("IOException =" + e.getMessage());
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}
