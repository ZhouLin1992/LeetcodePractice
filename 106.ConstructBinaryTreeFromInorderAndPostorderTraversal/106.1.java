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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        
        int val = postorder[poEnd];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        root.left = buildTree(inorder, inStart, idx - 1, postorder, poStart, poStart + idx - inStart - 1, map);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder, poEnd - inEnd + idx, poEnd - 1, map);
        return root;
    }
}