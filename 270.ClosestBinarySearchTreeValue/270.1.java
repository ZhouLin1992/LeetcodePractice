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
        TreeNode node = root;
        int result = node.val;

        while (node != null) {
            if (Math.abs(target - result) > Math.abs(target - node.val)) {
                result = node.val;
            }
            node = target < node.val ? node.left : node.right;
        }

        return result;
    }
}