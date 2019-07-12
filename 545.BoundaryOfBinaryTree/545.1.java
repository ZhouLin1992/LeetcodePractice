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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        
        if (!isLeaf(root)) {
            result.add(root.val);            
        }
        TreeNode p = root.left;
        
        while (p != null) {
            if (!isLeaf(p)) {
                result.add(p.val);
            }
            
            if (p.left != null) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        
        addLeaves(root, result);

        Deque<TreeNode> stack = new LinkedList<>();
        p = root.right;
        
        while (p != null) {
            if (!isLeaf(p)) {
                stack.push(p);
            }
            
            if (p.right != null) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }

        return result;        
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    
    private void addLeaves(TreeNode p, List<Integer> result) {
        if (isLeaf(p)) {
            result.add(p.val);
        }
        
        if (p.left != null) {
            addLeaves(p.left, result);
        }
        if (p.right != null) {
            addLeaves(p.right, result);
        }
    }
    
}