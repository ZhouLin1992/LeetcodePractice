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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isXExsit = false;
        boolean isYExsit = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 同一level进行比较
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == x) {
                    isXExsit = true;
                }
                if (curr.val == y) {
                    isYExsit = true;
                }
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (isXExsit && isYExsit) {
                return true;
            } else if (isXExsit || isYExsit) {
                return false;
            }
        }
        
        return false;
    }
}