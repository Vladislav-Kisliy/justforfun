/*
 * Copyright (C) 2016 Vladislav Kislyi <vladislav.kisliy@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class AllSortTest {

    public final Integer[] expResult = new Integer[]{
        -30, -29, -28, -27, -26, -25, -24, -23, -22, -21,
        -20, -19, -18, -17, -16, -15, -14, -13, -12, -11,
        -10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        10, 11, 12, 13, 14, 15, 16, 17, 18, 18, 19,
        20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
        30, 31, 32, 33, 33, 34, 35, 36, 37, 38, 39,
        40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
        50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
        60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
        70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
        80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 89,
        90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 99,
        100, 101, 102, 103, 104, 105, 106, 107, 108, 109,
        110, 111, 112, 113, 114, 115, 116, 117, 118, 119,
        120, 122, 124, 125, 126, 127, 128, 129,
        130, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139,
        140, 141, 142, 143, 144, 145, 146, 147, 148, 149,
        150, 151, 152, 153, 153, 154, 155, 156, 157, 157, 158, 159,
        160, 161, 162, 163, 164, 165, 166, 167, 168, 168, 169,
        170, 171, 172, 173, 174, 175, 176, 177, 178, 179,
        180, 181, 182, 183, 184, 185, 185, 187, 188, 189,
        190, 191, 192, 193, 194, 195, 196, 197, 198, 199,
        200, 201, 202, 203, 204, 205, 206, 207, 208, 209,
        210, 211, 212, 213, 214, 215, 216, 217, 218, 219,
        333};
    private Sorter<Integer> instance;
    
    private final AbstractSorterTest abstractSorterTest = new AbstractSorterTest();
    private final AbstractSorter<Integer> sortHelper = abstractSorterTest.new AbstractSorterImpl<>();

    /**
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSort() {
        instance = new BubbleSort<>();
//        Integer[] expResult = new Integer[]{-30, -29, -28, -27 };
//        Integer[] shuffleArray = sortHelper.shuffleArray(expResult);
//        System.out.println("Array ="+Arrays.toString(shuffleArray));
        
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testCombSort() {
        instance = new CombSort<>();
        
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testQuickSort() {
        instance = new QuickSort<>();
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testSelectionSort() {
        instance = new SelectionSort<>();
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testInsertSort() {
        instance = new InsertSort<>();
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testShellSort() {
        instance = new ShellSort<>();
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testMergeSort() {
        instance = new MergeSort<>();
        Integer[] result = instance.sort(sortHelper.shuffleArray(expResult));
        assertArrayEquals(expResult, result);
    }
}
