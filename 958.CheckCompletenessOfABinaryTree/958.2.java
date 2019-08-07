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
        
        List<ATreeNode> list = new LinkedList<>();
        list.add(new ATreeNode(root, 1));
        int i = 0;
        
        while (i < list.size()) {
            ATreeNode curr = list.get(i++);
            if (curr.node != null) {
                list.add(new ATreeNode(curr.node.left, 2 * curr.code));
                list.add(new ATreeNode(curr.node.right, 2 * curr.code + 1));
            }
        }
        
        return list.get(i - 1).code == list.size();
    }
    
}

class ATreeNode {
    TreeNode node;
    int code;
    
    public ATreeNode(TreeNode _node, int _code) {
        node = _node;
        code = _code;
    }
}