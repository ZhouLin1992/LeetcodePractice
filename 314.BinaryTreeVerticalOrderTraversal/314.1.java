// hashmap

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

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        nodes.add(root);
        cols.add(0);
        int minCol = 0;
        int maxCol = 0;

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int col = cols.poll();

            List<Integer> list = map.get(col);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(col, list);
            }
            list.add(curr.val);

            if (curr.left != null) {
                nodes.offer(curr.left);
                cols.offer(col - 1);
                minCol = Math.min(col - 1, minCol);
            }

            if (curr.right != null) {
                nodes.offer(curr.right);
                cols.offer(col + 1);
                maxCol = Math.max(col + 1, maxCol);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}