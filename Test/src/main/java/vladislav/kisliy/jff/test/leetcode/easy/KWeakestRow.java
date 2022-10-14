package vladislav.kisliy.jff.test.leetcode.easy;

import java.util.Arrays;

public class KWeakestRow {

    public int[] kWeakestRows(int[][] mat, int k) {
        Pair[] weight = new Pair[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            int[] currentPos = mat[i];
            for (int j = 0; j < currentPos.length; j++) {
                soldiers += currentPos[j];
            }
            weight[i] = new Pair(soldiers, i);
        }
        Arrays.sort(weight);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = weight[i].index;
        }
        return result;
    }

    private class Pair implements Comparable<Pair> {
        private final int soldiers;
        private final int index;

        public Pair(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.soldiers - o.soldiers;
        }
    }
}
