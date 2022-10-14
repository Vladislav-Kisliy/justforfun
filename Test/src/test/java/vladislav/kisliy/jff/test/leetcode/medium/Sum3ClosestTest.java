package vladislav.kisliy.jff.test.leetcode.medium;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.medium.Sum3Closest;

import static org.junit.Assert.*;

public class Sum3ClosestTest {

    @Test
    public void threeSumClosest() {
        Sum3Closest target = new Sum3Closest();
        assertEquals(2, target.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        assertEquals(0, target.threeSumClosest(new int[]{0,0,0}, 1));
        assertEquals(0, target.threeSumClosest(new int[]{0,0,0, 9, 9}, 2));
    }
}
