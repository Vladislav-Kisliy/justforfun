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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class DumbDigestTest {
    
    public DumbDigestTest() {
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

    /**
     * Test of doDigest method, of class DumbDigest.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullDigest() {
        byte[] input = null;
        DumbDigest instance = new DumbDigest();
        byte[] expResult = new byte[]{0, 0, 0, 1};
        byte[] result = instance.digest(input);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testDigest() {
        byte[] inputFirst = new byte[]{1};
        DumbDigest instance = new DumbDigest();
        byte[] expResult = new byte[]{0, 0, 0, 1};
        byte[] result = instance.digest(inputFirst);
        assertArrayEquals(expResult, result);
        
        byte[] inputSecond = new byte[]{2};
        expResult = new byte[]{0, 0, 0, 2};
        result = instance.digest(inputSecond);
        assertArrayEquals(expResult, result);
        
        byte[] inputThird = new byte[]{3};
        expResult = new byte[]{0, 0, 0, 3};
        result = instance.digest(inputThird);
        assertArrayEquals(expResult, result);
        
        expResult = new byte[]{0, 0, 0, 1};
        result = instance.digest(inputFirst);
        assertArrayEquals(expResult, result);
        
        expResult = new byte[]{0, 0, 0, 2};
        result = instance.digest(inputSecond);
        assertArrayEquals(expResult, result);
        
        expResult = new byte[]{0, 0, 0, 3};
        result = instance.digest(inputThird);
        assertArrayEquals(expResult, result);
    }
    
}
