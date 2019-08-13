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
package vladislav.kisliy.jff.test.codewars;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
@Ignore
public class TreeNodeSolutionTest {

    @Test
    public void emptyArray() {
        TreeNode expected = null;
        assertThat(TreeNodeSolution.arrayToTree(arrayFrom()), is(expected));
    }
    
    @Test
    public void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3),
                new TreeNode(15)), new TreeNode(-4));
        assertThat(TreeNodeSolution.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
    }

    @Test
    public void arrayWithMultipleElements2() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3),
                new TreeNode(15)), new TreeNode(-4, new TreeNode(18),
                new TreeNode(20)));
        assertThat(TreeNodeSolution.arrayToTree(arrayFrom(17, 0, -4, 3, 15, 18, 20)), is(expected));
    }
    
    private int[] arrayFrom(int... values) {
        return values;
    }

//    @Test
//    public void testGetFreeNode() {
//        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), 
//                new TreeNode(15)), new TreeNode(-4));
//        assertThat(TreeNodeSolution.getFreeNode(arrayFrom(17, 0, -4, 3, 15)), is(expected));
//    }
    
//    @Test
//    public void testGetFreeNode() {
//        TreeNode expected = new TreeNode(17);
//        assertThat(TreeNodeSolution.getFreeNode(expected), is(expected));
//        
//        expected.left = new TreeNode(0);
//        assertThat(TreeNodeSolution.getFreeNode(expected), is(expected));
//        
//        expected.right = new TreeNode(-4);
//        assertThat(TreeNodeSolution.getFreeNode(expected), is(expected.left));
//        
//        expected.left.left = new TreeNode(3);
//        expected.left.right = new TreeNode(15);
//        assertThat(TreeNodeSolution.getFreeNode(expected), is(expected.right));
//    }
//
//
//    /**
//     * Test of getNextParent method, of class TreeNodeSolution.
//     */
//    @Test
//    public void testGetNextParent() {
//        System.out.println("getNextParent");
//        TreeNode left = null;
//        TreeNode right = null;
//        TreeNode expResult = null;
//        TreeNode result = TreeNodeSolution.getNextParent(left, right);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRank method, of class TreeNodeSolution.
//     */
//    @Test
//    public void testGetRank() {
//        TreeNode expected = new TreeNode(17);
//        
//        expected.left = new TreeNode(0);
//        assertEquals(1, TreeNodeSolution.getRank(expected));
//        
//        expected.right = new TreeNode(-4);
//        
//        expected.left.left = new TreeNode(3);
//        expected.left.right = new TreeNode(15);
//        
//        assertEquals(-1, TreeNodeSolution.getRank(null));
//        assertEquals(0, TreeNodeSolution.getRank(expected.right));
//        assertEquals(2, TreeNodeSolution.getRank(expected));
//        assertEquals(2, TreeNodeSolution.getRank(expected.left));
//        assertEquals(0, TreeNodeSolution.getRank(expected.left.left));
//        
//    }

}