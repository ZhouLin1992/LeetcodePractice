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
	private int depth;
	public int maxDepth(TreeNode root) {
		depth = 0;
		maxDepth(root, 1);
		return depth;
	}

	public void maxDepth(TreeNode root, int curDepth) {
		if (root == null) {
			return;
		}

		if (curDepth > depth) {
			depth = curDepth;
		}

		maxDepth(root.left, curDepth + 1);
		maxDepth(root.right, curDepth + 1);
	}
}