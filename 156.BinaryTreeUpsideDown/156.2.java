/* iterative
https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure
*/

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
        	return root;
        }

        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode next = null;

        while(curr != null) {
        	next = curr.left;

        	curr.left = temp;
        	temp = curr.right;
        	curr.right = prev;

        	prev = curr;
        	curr = next;
        }

        return prev;
    }
}