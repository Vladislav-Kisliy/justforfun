/*
 * Copyright (C) 2015 Weigandt Consulting
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
package vladislav.kisliy.jff.tictactoe.beans;

import vladislav.kisliy.jff.tictactoe.beans.CellState;
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
public class CellStateTest {
    
    public CellStateTest() {
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
     * Test of values method, of class CellState.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        CellState[] expResult = {CellState.TIC, CellState.TAC, CellState.TOE};
        CellState[] result = CellState.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class CellState.
     */
    @Test
    public void testValueOf() {
        String name = "TIC";
        CellState expResult = CellState.TIC;
        CellState result = CellState.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOpposite method, of class CellState.
     */
    @Test
    public void testGetOpposite() {
        assertEquals(CellState.TIC, CellState.getOpposite(CellState.TAC));
        assertEquals(CellState.TAC, CellState.getOpposite(CellState.TIC));
        assertEquals(CellState.TOE, CellState.getOpposite(CellState.TOE));
    }
}
