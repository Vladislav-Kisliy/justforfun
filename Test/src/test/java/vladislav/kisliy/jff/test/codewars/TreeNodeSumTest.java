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

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class TreeNodeSumTest {

    @Test
    public void maxSumInNullTree() {
        TreeNode root = null;
        assertThat(TreeNodeSum.maxSum(root), is(0));
    }

    /**
     *      5
     *    /   \
     *  -22    11
     *  / \    / \
     * 9  50  9   2
     */
    @Test
    public void maxSumInPerfectTree() {
        TreeNode left = TreeNode.leaf(-22).withLeaves(9, 50);
        TreeNode right = TreeNode.leaf(11).withLeaves(9, 2);
        TreeNode root = TreeNode.join(5, left, right);
        assertThat(TreeNodeSum.maxSum(root), is(33));
    }

}
