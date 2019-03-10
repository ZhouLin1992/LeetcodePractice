// Use cache

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = map.get(preorder[preStart]);

        root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inIdx - 1, map);
        root.right = buildTreeHelper(preorder, inorder, preStart + inIdx - inStart + 1, inIdx + 1, inEnd, map);
        return root;
    }
}