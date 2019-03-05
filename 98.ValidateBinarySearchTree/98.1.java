/*
time: o(n), we visit each node exactly once
space: o(n), we keep up to the entire tree
*/


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
	private class TreeNodeHelper {
		boolean isBST;
		int maxVal;
		int minVal;
		private TreeNodeHelper(boolean isBST, int maxVal, int minVal) {
			this.isBST = isBST;
			this.maxVal = maxVal;
			this.minVal = minVal;
		}
	}

	public TreeNodeHelper isValidBSTHelper(TreeNode root) {
		if (root == null) {
			return new TreeNodeHelper(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		TreeNodeHelper left = isValidBSTHelper(root.left);
		TreeNodeHelper right = isValidBSTHelper(root.right);

		if (!left.isBST || !right.isBST) {
			return new TreeNodeHelper(false, 0, 0);
		}

		// corner case: only one Node with the value of Integer.MAX_VALUE
		if (root.left != null && left.maxVal >= root.val || root.right != null && right.minVal <= root.val) {
			return new TreeNodeHelper(false, 0, 0);
		}
		return new TreeNodeHelper(true, Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal));
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root).isBST;
	}
}