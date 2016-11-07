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
	// 1. maximum path can be in left subtree
	// 2. maximum path can be in right subtree
	// 3. maximum path can be in left subtree-> root -> right subtree
	private class TreeNodeHelper {
		// singlePath is max value in one direction from left/right subtree
		int singlePath;
		// maxPath is max value of left subtree -> root -> right subtree
		int maxPath;
		private TreeNodeHelper(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	public int maxPathSum(TreeNode root) {
		return maxPathSumHelper(root).maxPath;
	}

	private TreeNodeHelper maxPathSumHelper(TreeNode root) {
		if (root == null) {
			return new TreeNodeHelper(0, Integer.MIN_VALUE);
		}

		// Divide
		TreeNodeHelper left = maxPathSumHelper(root.left);
		TreeNodeHelper right = maxPathSumHelper(root.right);

		// Conquer
		// max sum of one direction from either left/right subtree going up
		// can either take it or not since the value can be negative
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(0, singlePath);

		// max sum can be in left subtree -> root -> right subtree only in a left/right subtree
		// or
		// can take root node into consideration
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

		return new TreeNodeHelper(singlePath, maxPath);
	}
}