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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{t1, t2});
        
        while (!queue.isEmpty()) {
            TreeNode[] top = queue.poll();
            
            if (top[1] == null) {
                continue;
            }
            
            top[0].val += top[1].val;
            if (top[0].left != null) {
                queue.offer(new TreeNode[]{top[0].left, top[1].left});
            } else {
                top[0].left = top[1].left;
            }
            
            if (top[0].right != null) {
                queue.offer(new TreeNode[]{top[0].right, top[1].right});
            } else {
                top[0].right = top[1].right;
            }
        }
        
        return t1;
    }
}