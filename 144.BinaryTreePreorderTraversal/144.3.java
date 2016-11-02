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
        preorderTraversal(root, preorder);
        return preorder;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}