// https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer
// http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

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
    public void recoverTree(TreeNode root) {
    	TreeNode tmp = null;
    	TreeNode prev = null;
    	TreeNode first = null;
    	TreeNode second = null;

    	while (root != null) {
    		if (root.left != null) {
	    		tmp = root.left;
	    		while (tmp.right != null && tmp.right != root) {
	    			tmp = tmp.right;
	    		}
	    		if (tmp.right == null) {
	    			tmp.right = root;
	    			root = root.left;
	    		} else {
	    			if (prev != null && prev.val >= root.val) {
	    				if (first == null) {
	    					first = prev;
                            second = root;
	    				} else {
	    					second = root;
	    				}
	    			}
	    			prev = root;

	    			tmp.right = null;
	    			root = root.right;
	    		}
    		} else {
    			if (prev != null && prev.val >= root.val) {
    				if (first == null) {
    					first = prev;
                        second = root;
    				} else {
    					second = root;
    				}
    			}
    			prev = root;

    			root = root.right;
    		}
    	}

    	if (first != null && second != null) {
    		int val = first.val;
    		first.val = second.val;
    		second.val = val;
    	}
    }
}