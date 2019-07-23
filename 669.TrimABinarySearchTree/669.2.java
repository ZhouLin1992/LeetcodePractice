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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        
        while (root != null && (root.val < L || root.val > R)) {
            if (root.val < L) {
                root = root.right;
            }
            if (root.val > R) {
                root = root.left;
            }
        }
        
        TreeNode dummy = root;
        while (dummy != null) {
            while (dummy.left != null && dummy.left.val < L) {
                dummy.left = dummy.left.right;
            }
            dummy = dummy.left;
        }
        
        dummy = root;
        
        while (dummy != null) {
            while (dummy.right != null && dummy.right.val > R) {
                dummy.right = dummy.right.left;
            }
            dummy = dummy.right;
        }
        
        return root;
    }
}