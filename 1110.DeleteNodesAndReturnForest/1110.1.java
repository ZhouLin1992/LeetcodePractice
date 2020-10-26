/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Set<Integer> set = new HashSet<Integer>();
        List<TreeNode> result = new LinkedList<>();
        
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) {
            result.add(root);
        }
        
        dfs(root, set, result);
        
        return result;
    }
    
    private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        
        root.left = dfs(root.left, set, result);
        root.right = dfs(root.right, set, result);
        
        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        
        return root;
    }
}