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
		return isBalancedHelper(root).isBalanced;
	}

	public treeNodeHelper isBalancedHelper(TreeNode root) {
		if (root ==  null) {
			return new treeNodeHelper(true, 0);
		}

		treeNodeHelper left = isBalancedHelper(root.left);
		treeNodeHelper right = isBalancedHelper(root.right);

		// subtree not balance
		if (!left.isBalanced || !right.isBalanced) {
			return new treeNodeHelper(false, -1);
		}

		// root not balance
		if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new treeNodeHelper(false, -1);
		}

		return new treeNodeHelper(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	}
}

class treeNodeHelper {
	public boolean isBalanced;
	public int maxDepth;
	public treeNodeHelper(boolean isBalanced, int maxDepth) {
		this.isBalanced = isBalanced;
		this.maxDepth = maxDepth;
	}
}