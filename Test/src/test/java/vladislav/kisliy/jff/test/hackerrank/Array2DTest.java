package vladislav.kisliy.jff.test.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 13.09.19.
 */
public class Array2DTest {

    private static final int[][] ARR_01 = new int[][]{
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
    };

    private static final int[][] ARR_02 = new int[][]{
            {0, -4, -6, 0, -7, -6},
            {-1, -2, -6, -8, -3, -1},
            {-8, -4, -2, -8, -8, -6},
            {-3, -1, -2, -5, -7, -4},
            {-3, -5, -3, -6, -6, -6},
            {-3, -6, 0, -8, -6, -7}
    };


//    @Test
//    public void extrackHourGlass() {
//        assertArrayEquals(new int[]{1, 1, 1}, Array2D.extrackHourGlass(ARR_01, 0, 0)[0]);
//    }

    @Test
    public void sumHourGlass() {
        assertEquals(7, Array2D.sumHourGlass(ARR_01, 0, 0));
        assertEquals(6, Array2D.sumHourGlass(ARR_01, 2, 1));
        assertEquals(19, Array2D.sumHourGlass(ARR_01, 3, 2));
    }

    @Test
    public void maxHourGlass() {
        assertEquals(19, Array2D.getMaxHourGlass(ARR_01));
        assertEquals(-19, Array2D.getMaxHourGlass(ARR_02));
    }
}