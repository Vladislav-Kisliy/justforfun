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
public class NewAverageTest {
    
    public NewAverageTest() {
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

    private static void testing(long actual, long expected) {
        assertEquals(expected, actual);
    }
    
     @Test
    public void test() {
        System.out.println("Fixed Tests newAvg");
        double[] a = new double[] {14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0};
        testing(NewAverage.newAvg(a, 90), 628);
        a = new double[] {14.2, 30.2, 5.4, 7.0, 9.0, 11.0, 16.8};
        testing(NewAverage.newAvg(a, 90), 627);
        a = new double[] {14, 30, 5, 7, 9, 11, 15};
        testing(NewAverage.newAvg(a, 92), 645);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException1() {
        System.out.println("--- Exception 1 ---");
        double[]a = new double[] {14, 30, 5, 7, 9, 11, 15};
        NewAverage.newAvg(a, 2);
    }    
    
    @Test
    public void testEmpty() {
        System.out.println("Fixed Tests newAvg");
        double[] a = new double[] {0};
        testing(NewAverage.newAvg(a, 90), 180);
        a = new double[] {};
        testing(NewAverage.newAvg(a, 92), 92);
    }
    
    
}
