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
		List<Integer> res = new ArrayList<>();
		postorderTraversal(root, res);
		return res;
	}

	public void postorderTraversal(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}

		postorderTraversal(root.left, res);
		postorderTraversal(root.right, res);
		res.add(root.val);        
    }
}