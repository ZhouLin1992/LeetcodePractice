// non-recursive: pre-order traversal

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        stack1.push(p);
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode peak1 = stack1.pop();
            TreeNode peak2 = stack2.pop();
            if (peak1.val != peak2.val) {
                return false;
            }
            if (peak1.right != null) {
                stack1.push(peak1.right);
            }
            if (peak2.right != null) {
                stack2.push(peak2.right);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
            if (peak1.left != null) {
                stack1.push(peak1.left);
            }
            if (peak2.left != null) {
                stack2.push(peak2.left);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
        }
        return stack1.size() == stack2.size();
    }
}