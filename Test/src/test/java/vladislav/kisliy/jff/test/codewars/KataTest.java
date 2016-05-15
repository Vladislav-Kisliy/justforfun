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
public class KataTest {

    public KataTest() {
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
    public void tests() {
        assertEquals(true, Kata.validPhoneNumber("(123) 456-7890"));
        assertEquals(false, Kata.validPhoneNumber("(1111)555 2345"));
        assertEquals(false, Kata.validPhoneNumber("(098) 123 4567"));
    }

    @Test
    public void Test1() {
        assertEquals("42 -9", Kata.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        assertEquals("5 1", Kata.HighAndLow("1 2 3 4 5"));
        assertEquals("5 -3", Kata.HighAndLow("1 2 -3 4 5"));
        assertEquals("9 -5", Kata.HighAndLow("1 9 3 4 -5"));
    }
    
//    public static String HighAndLow(String numbers) {
//
//        int min = Arrays.stream(numbers.split(" "))
//                        .mapToInt(i -> Integer.parseInt(i))
//                        .min()
//                        .getAsInt();
//
//        int max = Arrays.stream(numbers.split(" "))
//                        .mapToInt(i -> Integer.parseInt(i))
//                        .max()
//                        .getAsInt();
//
//        return String.format("%d %d", max, min);
//    }
    
//    public static String HighAndLow(String numbers) {
//    IntSummaryStatistics summary = Arrays
//      .stream(numbers.split(" "))
//      .collect(Collectors.summarizingInt(n -> Integer.parseInt(n)));
//    return String.format("%d %d", summary.getMax(), summary.getMin());
//  }

}
