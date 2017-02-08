// Divide & Conquer

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
        List<String> path = new ArrayList<>();
        if (root == null) {
            return path;
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        
        for (String str: left) {
            path.add(root.val + "->" + str);
        }
        for (String str: right) {
            path.add(root.val + "->" + str);
        }
        
        if (path.size() == 0) {
            path.add("" + root.val);
        }
        
        return path;
    }
}