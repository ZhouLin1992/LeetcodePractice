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
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<>();

		if (root == null) {
			return inorder;
		}

		// Divide
		List<Integer> left = inorderTraversal(root.left);
		List<Integer> right = inorderTraversal(root.right);

		// Conquer
		inorder.addAll(left);
		inorder.add(root.val);
		inorder.addAll(right);
		return inorder;
    }
}