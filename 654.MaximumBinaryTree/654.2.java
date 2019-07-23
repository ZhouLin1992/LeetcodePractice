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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            // keep poping if peek.val < curr.val, the last one fulfills the criteria it is the largest number among currNode left children
            while (!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            // after poping up peek that is peek.val < curr.val, now peek.val > curr.val and peek should be the root of curr
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.removeLast();
    }
}