/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode t = root;
        double diff = Math.abs(t.val - target);
        int res = root.val;
        while (t != null) {
            if (Math.abs(t.val - target) < diff) {
                res = t.val;
                diff = Math.abs(res - target);
            }
            t = target < t.val ? t.left : t.right;
        }
        return res;
    }
}