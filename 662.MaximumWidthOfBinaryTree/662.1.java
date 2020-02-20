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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        int maxWidth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                int index = map.get(currNode);
                if (i == 0) {
                    start = map.get(currNode);
                }
                if (i == size - 1) {
                    end = map.get(currNode);
                }
                if (currNode.left != null) {
                    map.put(currNode.left, 2 * index);
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    map.put(currNode.right, 2 * index + 1);
                    queue.offer(currNode.right);
                }
            }
            int currWidth = end - start + 1;
            maxWidth = Math.max(currWidth, maxWidth);
        }

        return maxWidth;
    }
}