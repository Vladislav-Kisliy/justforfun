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
public class ProdFibTest {

    public ProdFibTest() {
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
    public void test1() {
        long[] r = new long[]{55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }

    @Test
    public void test2() {
        long[] r = new long[]{89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }
    
    @Test
    public void test3() {
        long[] r = new long[]{21, 34, 1};
        assertArrayEquals(r, ProdFib.productFib(714));
    }
    
    @Test
    public void test4() {
        long[] r = new long[]{34, 55, 0};
        assertArrayEquals(r, ProdFib.productFib(800));
    }
    
    @Test
    public void test5() {
        long[] r = new long[]{1836311903, 2971215073l, 0};
        assertArrayEquals(r, ProdFib.productFib(4456077604922913920l));
    }
}
