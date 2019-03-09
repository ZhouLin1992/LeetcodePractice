// https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal

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
	TreeNode first;
	TreeNode second;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
    	traverse(root);
    	
    	int tmp = first.val;
    	first.val = second.val;
    	second.val = tmp;
    }

    private void traverse(TreeNode root) {
    	if (root == null) {
    		return;
    	}

    	traverse(root.left);

    	if (first == null && prev.val >= root.val) {
    		first = prev;
    	}

    	if (first != null && prev.val >= root.val) {
    		second = root;
    	}

    	prev = root;

    	traverse(root.right);
    }
}