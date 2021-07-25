package vladislav.kisliy.jff.test.codeforces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStoneTest {

    private GameStone testTarget;

    @Before
    public void setUp() throws Exception {
        testTarget = new GameStone();
    }

    @Test
    public void calculateSteps() {
        assertEquals(2, testTarget.calculateSteps(new int[]{1, 2}));
        assertEquals(2, testTarget.calculateSteps(new int[]{1, 5, 4, 3, 2}));
        assertEquals(4, testTarget.calculateSteps(new int[]{2, 1, 3, 4, 5, 6, 8, 7}));
        System.out.println("==========");
        assertEquals(5, testTarget.calculateSteps(new int[]{4, 2, 3, 1, 8, 6, 7, 5}));
        assertEquals(3, testTarget.calculateSteps(new int[]{3, 4, 2, 1}));
        assertEquals(2, testTarget.calculateSteps(new int[]{2, 3, 1, 4}));
    }

    @Test
    public void calculateSteps2() {
        assertEquals(2, testTarget.calculateSteps(new int[]{1, 3, 2, 4, 5}));
        assertEquals(54, testTarget.calculateSteps(new int[]{18, 55, 82, 66, 31, 26, 8, 96, 50, 58, 15, 14, 91, 54, 27, 57, 20, 53, 92, 5, 67, 22, 19, 63, 68, 84, 95, 64, 78, 72, 83, 47, 32, 81, 37, 97, 88, 77, 93, 12, 2,
                62, 3, 13, 86, 33, 1, 42, 17, 21, 70, 65, 4, 98, 69, 61, 10, 39, 74, 59, 9, 34, 43, 45, 100, 40, 99, 51, 28, 75, 35, 16, 44, 49, 23, 90, 36, 38, 79, 7, 87,
                24, 41, 56, 89, 29, 85, 52, 73, 80, 94, 71, 46, 25, 11, 76, 48, 30, 60, 6}));
        assertEquals(39, testTarget.calculateSteps(new int[]{85, 45, 71, 26, 92, 66, 18, 36, 63, 74, 31, 83, 9, 21, 1, 48, 61, 4, 82, 91, 60, 11, 29, 13, 17, 40, 42, 84, 99, 33, 90, 88, 97, 94, 12, 76, 50, 6, 8, 81, 10,
                75, 19, 73, 80, 23, 43, 32, 28, 22, 86, 62, 44, 24, 5, 72, 34, 95, 49, 56, 20, 25, 14, 78, 15, 47, 41, 58, 68, 93, 98, 3, 59, 27, 53, 64, 100, 2, 7, 65, 55,
                87, 52, 16, 37, 46, 67, 30, 89, 69, 57, 38, 39, 77, 54, 96, 79, 51, 70, 35}));
    }
}