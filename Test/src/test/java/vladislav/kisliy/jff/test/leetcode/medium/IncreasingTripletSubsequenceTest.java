package vladislav.kisliy.jff.test.leetcode.medium;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.medium.IncreasingTripletSubsequence;

import static org.junit.Assert.*;

public class IncreasingTripletSubsequenceTest {

    @Test
    public void increasingTriplet() {
        IncreasingTripletSubsequence target = new IncreasingTripletSubsequence();
        assertTrue(target.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        assertTrue(target.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        assertTrue(target.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        assertFalse(target.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        assertFalse(target.increasingTriplet(new int[]{1, 2}));
        assertFalse(target.increasingTriplet(new int[]{20, 100, 13, 12, 5, 13}));
        assertFalse(target.increasingTriplet(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }
}