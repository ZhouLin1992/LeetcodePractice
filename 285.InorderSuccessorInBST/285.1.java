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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // possible successor
        TreeNode succ = null;
        
        // find p
        while (root != null && root.val != p.val) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        
        // if p is not in the tree
        if (root == null) {
            return null;
        }
        
        // if p does not have any right subtrees
        // its parent is its successor
        if (root.right == null) {
            return succ;
        }
        
        // if p has right subtrees
        // traverse down right subtrees
        // find out the smallest value that is larger than p.val
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}