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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
		LinkedList<TreeNode> nodes = new LinkedList<>();
		LinkedList<Integer> sums = new LinkedList<>();

		nodes.add(root);
		sums.add(sum - root.val);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.pollLast();
			sum = sums.pollLast();

			if (node.left == null && node.right == null && sum == 0) {
				return true;
			}

			if (node.left != null) {
				nodes.add(node.left);
				sums.add(sum - node.left.val);
			}

			if (node.right != null) {
				nodes.add(node.right);
				sums.add(sum - node.right.val);
			}
		}

		return false;
    }
}