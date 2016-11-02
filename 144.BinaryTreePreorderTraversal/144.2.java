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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        
        if (root == null) {
            return preorder;
        }
        
        // Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        // Conquer
        preorder.add(root.val);
        preorder.addAll(left);
        preorder.addAll(right);
        return preorder;
    }
}