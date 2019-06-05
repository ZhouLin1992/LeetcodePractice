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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sPreorder = generatePreorder(s);
        String tPreorder = generatePreorder(t);
        
        return sPreorder.contains(tPreorder);
    }
    
    private String generatePreorder(TreeNode root) {        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            
            if (head != null) {
                sb.append(",");
                sb.append(head.val);
            } else {
                sb.append(",#");
            }
            
            if (head != null) {
                stack.push(head.right);
                stack.push(head.left);
            }
        }
        
        return sb.toString();
    }
}