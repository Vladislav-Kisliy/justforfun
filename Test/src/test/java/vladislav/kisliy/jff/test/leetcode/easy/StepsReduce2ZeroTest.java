package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class StepsReduce2ZeroTest {

    @Test
    public void numberOfSteps() {
        StepsReduce2Zero target = new StepsReduce2Zero();
        assertEquals(6, target.numberOfSteps(14));
        assertEquals(4, target.numberOfSteps(8));
        assertEquals(12, target.numberOfSteps(123));
    }
}
