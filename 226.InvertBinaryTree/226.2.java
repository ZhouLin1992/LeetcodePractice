// queue + BFS (level order traversal)

public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode peak = queue.poll();
			TreeNode tmp = peak.left;
			peak.left = peak.right;
			peak.right = tmp;

			if (peak.left != null) {
				queue.offer(peak.left);
			}

			if (peak.right != null) {
				queue.offer(peak.right);
			}
		}
		return root;
	}
}