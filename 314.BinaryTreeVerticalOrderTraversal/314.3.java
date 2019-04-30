// get the range first

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int[] range = {0, 0};
        getRange(root, range, 0);

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        nodes.offer(root);
        cols.offer(-range[0]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = range[0]; i <= range[1]; i++) {
            result.add(new ArrayList<Integer>());
        }

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int col = cols.poll();

            result.get(col).add(curr.val);

            if (curr.left != null) {
                nodes.offer(curr.left);
                cols.offer(col - 1);
            }

            if (curr.right != null) {
                nodes.offer(curr.right);
                cols.offer(col + 1);
            }
        }

        return result;
    }

    private void getRange(TreeNode root, int[] range, int col) {
        if (root == null) {
            return;
        }

        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);

        getRange(root.left, range, col - 1);
        getRange(root.right, range, col + 1);
    }
}