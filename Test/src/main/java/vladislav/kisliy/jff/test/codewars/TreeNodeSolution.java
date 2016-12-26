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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class TreeNodeSolution {

    static TreeNode arrayToTree(int[] array) {
        int[] arr = new int[array.length + 1];
        System.arraycopy(array, 0, arr, 1, array.length);
        return build(arr, 1);
    }

    static TreeNode build(int[] array, int start) {
        if (start >= array.length) {
            return null;
        }
        TreeNode root = new TreeNode(array[start]);
        root.left = build(array, 2 * start);
        root.right = build(array, 2 * start + 1);
        return root;
    }
    
    
    // Another solution
//    static TreeNode arrayToTree(int[] array) {
//        if (array.length == 0)
//          return null;
//        TreeNode root = new TreeNode(array[0]);
//        
//        for(int i = 1; i < array.length;  i++) {
//          add(root, array[i]);
//        }
//        return root; // TODO: implementation
//    }
//    
    private static List<TreeNode> getNextRow(List<TreeNode> prevRow) {
      List<TreeNode> result = new ArrayList<>();
      for (TreeNode node : prevRow) {
        if (node.left != null)
          result.add(node.left);
        if (node.right != null)
          result.add(node.right);
      }
      return result;
    }
    
    private static boolean tryToAdd(List<TreeNode> row, TreeNode newNode) {
        for (TreeNode node : row) {
          if (node.left == null) {
            node.left = newNode;
            return true;
          }
          if (node.right == null) {
            node.right = newNode;
            return true;
          }
        }
        return false;
    }
    
    private static void add(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        List<TreeNode> row = Collections.singletonList(root);
        while (!tryToAdd(row, newNode)) {
          row = getNextRow(row);
        }
    }
}
