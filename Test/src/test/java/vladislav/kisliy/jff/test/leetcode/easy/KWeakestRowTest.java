package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class KWeakestRowTest {

    @Test
    public void kWeakestRows() {
        KWeakestRow target = new KWeakestRow();
        assertArrayEquals(new int[]{2, 0, 3}, target.kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3));
        assertArrayEquals(new int[]{0, 2}, target.kWeakestRows(new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2));
    }
}
