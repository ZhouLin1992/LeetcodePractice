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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Map<TreeNode, Integer> map = new HashMap<>();
        int max = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null && !map.containsKey(top.left)) {
                stack.push(top.left);
            } else if (top.right != null && !map.containsKey(top.right)) {
                stack.push(top.right);
            } else {
                TreeNode curr = stack.pop();
                int left = map.getOrDefault(curr.left, 0);
                int right = map.getOrDefault(curr.right, 0);
                map.put(curr, Math.max(left, right) + 1);
                max = Math.max(max, left + right);
            }
        }
        
        return max;
    }
}