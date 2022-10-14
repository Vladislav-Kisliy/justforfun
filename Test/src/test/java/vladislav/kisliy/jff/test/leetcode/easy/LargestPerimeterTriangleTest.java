package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestPerimeterTriangleTest {

    @Test
    public void largestPerimeter() {
        LargestPerimeterTriangle target = new LargestPerimeterTriangle();
        assertEquals(5, target.largestPerimeter(new int[]{2, 1, 2}));
        assertEquals(0, target.largestPerimeter(new int[]{1, 2, 1}));
    }
}