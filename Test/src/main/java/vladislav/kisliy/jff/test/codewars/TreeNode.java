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

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }
    
    static TreeNode leaf(int i) {
        return new TreeNode(i);
    }

    static TreeNode join(int i, TreeNode left, TreeNode right) {
        return new TreeNode(i, left, right);
    }
    
    TreeNode withLeaves(int left, int right) {
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
        return this;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 29 * hash + this.value;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final TreeNode other = (TreeNode) obj;
//        if (this.value != other.value) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "TreeNode{" + "value=" + value + '}';
    }
}
