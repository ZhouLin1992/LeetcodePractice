/*
time: o(n)
space: 
    worse case: o(n) (the tree is completely unbalanced, e.g. each node has only one child node)
    best case: o(logn) (the tree is completely balanced)
*/

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepthHelper(root);
    }
    
    private int minDepthHelper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
    }
}