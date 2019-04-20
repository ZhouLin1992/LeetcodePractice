// https://leetcode.com/problems/closest-binary-search-tree-value/discuss/70322/Super-clean-recursive-Java-solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        return closestValue(root, target, root.val);
    }

    private int closestValue(TreeNode root, double target, int result) {
        if (root == null) {
            return result;
        }

        if (Math.abs(result - target) > Math.abs(root.val - target)) {
            result = root.val;
        }

        if (target < root.val) {
            result = closestValue(root.left, target, result);
        }

        if (target > root.val) {
            result = closestValue(root.right, target, result);
        }

        return result;
    }
}