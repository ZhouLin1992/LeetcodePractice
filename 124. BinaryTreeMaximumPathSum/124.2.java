// Traverse nodes in post order, store the maximum root paths in cache and update the max value

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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxPath = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxPathSumMap = new HashMap<>();
        maxPathSumMap.put(null, 0);

        for (TreeNode node : postOrder(root)) {
            int left = Math.max(maxPathSumMap.get(node.left), 0);
            int right = Math.max(maxPathSumMap.get(node.right), 0);
            maxPathSumMap.put(node, Math.max(left, right) + node.val);
            maxPath = Math.max(maxPath, left + right + node.val);
        }

        return maxPath;
    }

    private List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();

        TreeNode prev = null;
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            curr = stack.peek();
            // traverse down
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            // traverse up
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                result.add(curr);
                stack.pop();
            }

            prev = curr;
        }

        return result;
    }
}