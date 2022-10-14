package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.easy.RichestCustomerWealth;

import static org.junit.Assert.*;

public class RichestCustomerWealthTest {

    @Test
    public void maximumWealth() {
        RichestCustomerWealth target = new RichestCustomerWealth();

        assertEquals(6, target.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        assertEquals(10, target.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
        assertEquals(17, target.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}
