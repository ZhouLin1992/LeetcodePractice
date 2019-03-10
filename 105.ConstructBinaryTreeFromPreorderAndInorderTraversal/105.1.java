// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    	if (inStart > inEnd) {
    		return null;
    	}

    	TreeNode root = new TreeNode(preorder[preStart]);
    	int inIdx = inStart;
    	for (int i = inStart; i <= inEnd; i++) {
    		if (inorder[i] == preorder[preStart]) {
    			inIdx = i;
    			break;
    		}
    	}

    	root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIdx - 1);
    	root.right = buildTreeHelper(preorder, inorder, preStart + inIdx - inStart + 1, inIdx + 1, inEnd);
    	return root;
    }
}