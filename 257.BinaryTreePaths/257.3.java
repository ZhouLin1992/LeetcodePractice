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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<String> paths = new LinkedList<>();
        nodes.push(root);
        paths.push(String.valueOf(root.val));
        TreeNode node;
        String path;

        while (!nodes.isEmpty()) {
        	node = nodes.pop();
        	path = paths.pop();
        	if (node.left == null && node.right == null) {
        		result.add(path);
        	}
        	if (node.left != null) {
        		nodes.push(node.left);
        		paths.push(path + "->" + node.left.val);
        	}
        	if (node.right != null) {
        		nodes.push(node.right);
        		paths.push(path + "->" + node.right.val);
        	}
        }

        return result;
    }
}