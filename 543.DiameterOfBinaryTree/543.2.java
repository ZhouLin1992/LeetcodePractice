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
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root)[0];
    }
    
    // {best, height}
    private int[] maxDepth(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        
        int[] left = maxDepth(root.left);
        int[] right = maxDepth(root.right);
        
        int max = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = Math.max(left[1], right[1]) + 1;
        
        return new int[] {max, height};
    }
}