package vladislav.kisliy.jff.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV {
    Set<Integer> valueIndex = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return recursiveCall(root, k);
    }

    private boolean recursiveCall(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (valueIndex.contains(k - root.val)) {
            return true;
        }
        valueIndex.add(root.val);
        return recursiveCall(root.left, k) || recursiveCall(root.right, k);
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
