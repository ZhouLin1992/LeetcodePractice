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
    public List<Integer> postorderTraversal(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		List<Integer> postorder = new ArrayList<>();
		// previously traversed node
		TreeNode prev = null;
		TreeNode cur = root;

		if (root == null) {
			return postorder;
		}

		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				// traverse down the tree
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (cur.left == prev) {
				// traverse up the tree from the left
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else {
				// traverse up the tree from the right
				postorder.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}
		return postorder;
    }
}