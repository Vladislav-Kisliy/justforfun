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

import java.util.Arrays;
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
public class NbInSumTest {

    public NbInSumTest() {
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

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests decompose");
        long[][] ans = NbInSum.decompose(0);
        String ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[][0]");
        ans = NbInSum.decompose(4);
        ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[2][0]");
        ans = NbInSum.decompose(9);
        ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[3][1]");
        ans = NbInSum.decompose(25);
        ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[4, 2][0]");
        ans = NbInSum.decompose(45);
        ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[5, 2][4]");
    }
    
    @Test
    public void test2() {
        System.out.println("Fixed Tests decompose");
        long[][] ans = NbInSum.decompose(0);
        String ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[][0]");        
        ans = NbInSum.decompose(8330475);
        ansStr = Arrays.toString(ans[0]) + Arrays.toString(ans[1]);
        testing(ansStr, "[[22, 13, 10, 8, 7, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2], 0]");
        
    }

}
