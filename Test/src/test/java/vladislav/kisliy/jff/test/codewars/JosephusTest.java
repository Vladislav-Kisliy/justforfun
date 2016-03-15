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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author vlad
 */
public class JosephusTest {

    public JosephusTest() {
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
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1, new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    public void test2() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2, new Object[]{2, 4, 6, 8, 10, 3, 7, 1, 9, 5});
    }

    @Test
    public void test3() {
        josephusTest(new Object[]{"C", "o", "d", "e", "W", "a", "r", "s"}, 4, new Object[]{"e", "s", "W", "o", "C", "d", "r", "a"});
    }

    @Test
    public void test4() {
        josephusTest(new Object[]{1, 2, 3, 4, 5, 6, 7}, 3, new Object[]{3, 6, 2, 7, 5, 1, 4});
    }

    @Test
    public void test5() {
        josephusTest(new Object[]{}, 3, new Object[]{});
    }
    
    @Test
    public void test6() {
        josephusTest(new Object[]{13, 14, 44, 48, 48, 134, 156, 197}, 2, new Object[]{44, 14, 197, 134, 48, 156, 48, 13});
    }
    
    private void josephusTest(final Object[] items, final int k, final Object[] result) {
        assertThat(Josephus.josephusPermutation(new ArrayList(Arrays.asList(items)), k), is(Arrays.asList(result)));
    }

}
