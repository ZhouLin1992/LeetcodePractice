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
		List<Integer> postorder = new ArrayList<>();

		if (root == null) {
			return postorder;
		}

		List<Integer> left = postorderTraversal(root.left);
		List<Integer> right = postorderTraversal(root.right);

		postorder.addAll(left);
		postorder.addAll(right);
		postorder.add(root.val);
		return postorder;        
    }
}