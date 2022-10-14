package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    private TwoSum target;

    @Before
    public void setUp() {
        target = new TwoSum();

    }

    @Test
    public void twoSum() {
        int[] result = target.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
        result = target.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
