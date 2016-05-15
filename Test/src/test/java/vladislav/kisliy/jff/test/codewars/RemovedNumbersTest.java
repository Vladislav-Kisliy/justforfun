/*
 * Copyright (C) 2016 vlad
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
package vladislav.kisliy.jff.test.codewars;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vlad
 */
public class RemovedNumbersTest {

    public RemovedNumbersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
        @Test
    public void test() {
        List<long[]> a = RemovedNumbers.removNb(220);
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[]{150, 160});
        res.add(new long[]{160, 150});
        assertTrue(a.size() == 2);
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));
        
        a = RemovedNumbers.removNb(358);
        res.clear();
        res.add(new long[]{252, 253});
        res.add(new long[]{253, 252});
        assertEquals(2, a.size());
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));
    }

    @Test
    public void test12() {
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[]{15, 21});
        res.add(new long[]{21, 15});
        List<long[]> a = RemovedNumbers.removNb(26);
        assertTrue(a.size() == 2);
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));
    }

//    @Test
//    public void test14() {
//        List<long[]> res = new ArrayList<long[]>();
//        List<long[]> a = RemovedNumbers.removNb(100);
//        assertTrue(res.size() == a.size());
//    }
//    
//    @Test
//    public void test3() {
//        List<long[]> a = RemovedNumbers.removNb(101);
//        List<long[]> res = new ArrayList<long[]>();
//        res.add(new long[]{55, 91});
//        res.add(new long[]{91, 55});
//        assertTrue(a.size() == 2);
//        assertArrayEquals(res.get(0), a.get(0));
//        assertArrayEquals(res.get(1), a.get(1));
//    }
//    
//    @Test
//    public void test4() {
//        List<long[]> a = RemovedNumbers.removNb(102);
//        assertTrue(a.size() == 2);
//        List<long[]> res = new ArrayList<long[]>();
//        res.add(new long[]{70, 73});
//        res.add(new long[]{73, 70});
//        assertArrayEquals(res.get(0), a.get(0));
//        assertArrayEquals(res.get(1), a.get(1));
//    }
//    
//    @Test
//    public void test10() {
//        List<long[]> a = RemovedNumbers.removNb(1000003);
//        assertTrue(2 == a.size());
//        List<long[]> res = new ArrayList<long[]>();
//        res.add(new long[]{550320, 908566});
//        res.add(new long[]{908566, 550320});
//        assertArrayEquals(res.get(0), a.get(0));
//        assertArrayEquals(res.get(1), a.get(1));
//    }
//    
//   @Test
//    public void test11() {
//        List<long[]> a = RemovedNumbers.removNb(1000008);
//        assertTrue(2 == a.size());
//        List<long[]> res = new ArrayList<long[]>();
//        res.add(new long[]{677076, 738480});
//        res.add(new long[]{738480, 677076});
//        assertArrayEquals(res.get(0), a.get(0));
//        assertArrayEquals(res.get(1), a.get(1));
//    }
}
