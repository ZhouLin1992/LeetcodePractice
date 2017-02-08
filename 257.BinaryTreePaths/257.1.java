// traverse

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        
        dfs(root, rst, "" + root.val);
        return rst;
    }
    
    private void dfs(TreeNode root, List<String> rst, String str) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            rst.add(str);
            return;
        }
        
        if (root.left != null) {
            dfs(root.left, rst, str + "->" + root.left.val);
        }
        
        if (root.right != null) {
            dfs(root.right, rst, str + "->" + root.right.val);
        }
    }
}