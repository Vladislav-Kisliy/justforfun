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
package vladislav.kisliy.jff.test.file;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class IntegerFileProcessorTest {

    private static final String FILENAME = "/home/vlad/work/projects/school/int_array.bin";
    private static final String FILENAME_SORTED = "/home/vlad/work/projects/school/int_array_sorted.bin";

    @Test
    public void testSorted() {
        IntegerFileProcessor instance = new IntegerFileProcessor(FILENAME_SORTED);
        boolean expResult = true;
        boolean result = instance.isSorted();
        assertEquals(expResult, result);
    }

    @Test
    public void testUnSorted() {
        IntegerFileProcessor instance = new IntegerFileProcessor(FILENAME);
        boolean expResult = false;
        boolean result = instance.isSorted();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectFilename() {
        new IntegerFileProcessor(null);
    }

    @Test(expected = RuntimeException.class)
    public void testSortWrapException() {
        IntegerFileProcessor instance = new IntegerFileProcessor("/sasasasasas");
        boolean result = instance.isSorted();
    }

    /**
     * Test of fillArray method, of class IntegerFileProcessor.
     */
    @Test
    public void testFillArray() {
        IntegerFileProcessor instance = new IntegerFileProcessor(FILENAME_SORTED);
        Integer[] expResult = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] result = instance.fillArray(1, 10);
        assertArrayEquals(expResult, result);

        expResult = new Integer[]{2, 3, 4, 5, 6, 7, 8};
        result = instance.fillArray(2, 9);
        assertArrayEquals("Case: [2-8]", expResult, result);

        expResult = new Integer[]{3002, 3003, 3004, 3005, 3006, 3007, 3008};
        result = instance.fillArray(3002, 3009);
        assertArrayEquals("Case: [3002-3008]", expResult, result);

        int shift = 100;
        int longerThanMax = 1024 + shift;
        expResult = new Integer[longerThanMax];
        for (int i = 0; i < expResult.length; i++) {
            expResult[i] = shift + i;
        }
        result = instance.fillArray(shift, longerThanMax + shift);
        assertArrayEquals("Case: [100-1124]", expResult, result);

        shift = 5000;
        expResult = new Integer[500];
        for (int i = 0; i < expResult.length; i++) {
            expResult[i] = shift + i;
        }
        result = instance.fillArray(shift, 6000);
        assertArrayEquals("Case: [5000-end]", expResult, result);
    }

    @Test(expected = RuntimeException.class)
    public void testFillWrapException() {
        IntegerFileProcessor instance = new IntegerFileProcessor("/sasasasasas");
        instance.fillArray(1, 10);
    }

}
