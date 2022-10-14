package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RopeColorfulTest {

    @Test
    public void minCost() {
        RopeColorful target = new RopeColorful();
        assertEquals(3, target.minCost("abaac", new int[]{1, 2, 3, 4, 5}));
        assertEquals(0, target.minCost("abc", new int[]{1, 2, 3}));
        assertEquals(2, target.minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
        assertEquals(26, target.minCost("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}));
    }
}
