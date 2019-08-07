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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode peek = root;
        while (peek != null) {
            queue.offer(peek.left);
            queue.offer(peek.right);
            peek = queue.poll();
        }

        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }

        return queue.isEmpty();
    }
}