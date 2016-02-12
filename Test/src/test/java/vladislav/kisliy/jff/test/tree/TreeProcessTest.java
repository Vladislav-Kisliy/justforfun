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
package vladislav.kisliy.jff.test.tree;

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
public class TreeProcessTest {

    private final List<TreeType> plainList;

    public TreeProcessTest() {
        plainList = new ArrayList<TreeType>();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        plainList.add(new TreeType(2l, null, "2"));
//        plainList.add(new TreeType(211l, 21l));
//        plainList.add(new TreeType(212l, 21l));
//        plainList.add(new TreeType(213l, 21l));
        plainList.add(new TreeType(21l, 2l, "21"));
        plainList.add(new TreeType(22l, 2l, "22"));
        plainList.add(new TreeType(23l, 2l, "23"));
        plainList.add(new TreeType(3l, null, "3"));
        plainList.add(new TreeType(33l, 3l, "33"));
        plainList.add(new TreeType(33l, 3l, "33"));
        plainList.add(new TreeType(33l, 3l, "33"));
        plainList.add(new TreeType(4l, null, "4"));
        plainList.add(new TreeType(41l, 4l, "41"));
        plainList.add(new TreeType(42l, 4l, "42"));
        plainList.add(new TreeType(43l, 4l, "43"));

        plainList.add(new TreeType(5l, null, "5"));

        plainList.add(new TreeType(211l, 21l, "33"));
        plainList.add(new TreeType(212l, 21l, "33"));
        plainList.add(new TreeType(213l, 21l, "33"));

        plainList.add(new TreeType(51l, 5l, "51"));
        plainList.add(new TreeType(52l, 5l, "52"));
        plainList.add(new TreeType(53l, 5l, "51"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getParentNode method, of class TreeProcess.
     */
    @Test
    public void testGetParentNode() {
        System.out.println("getParentNode");
        TreeProcess instance = new TreeProcess(plainList);
        Tree<TreeType> expResult = null;
        Tree<TreeType> result = instance.getParentNode();
        System.out.println("-test: result:\r\n" + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
