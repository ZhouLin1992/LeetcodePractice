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
	public boolean isValidBST(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		TreeNode prev = null;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if (prev != null && prev.val >= cur.val) {
				return false;
			}
			prev = cur;
			cur = cur.right;
		}
		return true;
	}
}
