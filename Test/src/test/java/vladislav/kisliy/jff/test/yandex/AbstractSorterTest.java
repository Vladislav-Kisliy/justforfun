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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
@Ignore
public class AbstractSorterTest {
    
    public AbstractSorterTest() {
    }
    
    /**
     * Test of swap method, of class AbstractSorter.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Comparable[] input = null;
        int srcPos = 0;
        int dstPos = 0;
        AbstractSorter instance = new AbstractSorterImpl();
        instance.swap(input, srcPos, dstPos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleArray method, of class AbstractSorter.
     */
    @Test
    public void testShuffleArray() {
        System.out.println("shuffleArray");
        Comparable[] inputArray = null;
        AbstractSorter instance = new AbstractSorterImpl();
        Comparable[] expResult = null;
        Comparable[] result = instance.shuffleArray(inputArray);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of more method, of class AbstractSorter.
     */
    @Test
    public void testMore() {
        AbstractSorter instance = new AbstractSorterImpl();
        assertFalse(instance.more(1, 2));
        assertFalse(instance.more(10, 20));
        assertTrue(instance.more(12, 2));
        assertTrue(instance.more(200, 2));
    }

    public class AbstractSorterImpl<T extends Comparable> extends AbstractSorter {

        @Override
        public Comparable[] sort(Comparable[] input) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
