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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// p and q are found in different subtree
		if (left != null && right != null) {
			return root;
		}

		// one treenode(p or q) is found in one subtree
		if (left != null) {
			return left;			
		}

		if (right != null) {
			return right;
		}

		return null;        
    }
}