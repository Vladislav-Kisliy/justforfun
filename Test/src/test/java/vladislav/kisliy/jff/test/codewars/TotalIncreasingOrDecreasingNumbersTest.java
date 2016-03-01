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

import java.math.BigInteger;
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
public class TotalIncreasingOrDecreasingNumbersTest {

    public TotalIncreasingOrDecreasingNumbersTest() {
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

    private static void tester(int inp, BigInteger exp) {
        assertEquals("Testing for total below 10<sup>" + inp + "</sup>\n", exp, TotalIncreasingOrDecreasingNumbers.totalIncDec(inp));
    }

    @Test
    public void basicTests() {
        tester(0, BigInteger.valueOf(1));
        tester(1, BigInteger.valueOf(10));
        tester(2, BigInteger.valueOf(100));
        tester(3, BigInteger.valueOf(475));
        tester(4, BigInteger.valueOf(1675));
    }
}
