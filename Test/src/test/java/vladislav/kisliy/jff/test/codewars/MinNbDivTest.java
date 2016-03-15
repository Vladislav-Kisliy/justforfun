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
public class MinNbDivTest {
    
    public MinNbDivTest() {
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
        System.out.println("Fixed Tests");
        assertEquals(1, MinNbDiv.findMinNum(1));
        assertEquals(12, MinNbDiv.findMinNum(6));
        assertEquals(24, MinNbDiv.findMinNum(8));
        assertEquals(36, MinNbDiv.findMinNum(9));
        assertEquals(48, MinNbDiv.findMinNum(10));
        assertEquals(1024, MinNbDiv.findMinNum(11));
        assertEquals(60, MinNbDiv.findMinNum(12));
        assertEquals(4096, MinNbDiv.findMinNum(13));
        assertEquals(192, MinNbDiv.findMinNum(14));
        assertEquals(144, MinNbDiv.findMinNum(15));
        assertEquals(65536, MinNbDiv.findMinNum(17));
    }
    
    @Test
    public void test2() {
        assertEquals(64, MinNbDiv.findMinNum(7));
        assertEquals(144, MinNbDiv.findMinNum(15));
    }
//    
    @Test
    public void test3() {
        assertEquals(48, MinNbDiv.findMinNum(10));
        assertEquals(240, MinNbDiv.findMinNum(20));
        assertEquals(720, MinNbDiv.findMinNum(30));
        assertEquals(1680, MinNbDiv.findMinNum(40));
        assertEquals(6480, MinNbDiv.findMinNum(50));
        assertEquals(5040, MinNbDiv.findMinNum(60));
        assertEquals(15120, MinNbDiv.findMinNum(80));
        assertEquals(45360, MinNbDiv.findMinNum(100));
    }
}
