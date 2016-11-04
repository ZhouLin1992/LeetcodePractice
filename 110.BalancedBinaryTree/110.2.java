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
	public boolean isBalanced(TreeNode root) {
		return maxDepth(root) != -1;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// left subtree
		int left = maxDepth(root.left);
		// right subtree
		int right = maxDepth(root.right);

		// left subtree & right subtree & the root of the left subtree and right subtree
		// is not balanced
		if (left == -1 || right == -1 || Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}
}
