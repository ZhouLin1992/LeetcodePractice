// o(N), in order traversal and find k closest elements in the array


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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        traverse(root, values);

        int i = 0;
        int size = values.size();

        for (; i < size; i++) {
            if (values.get(i) >= target) {
                break;
            }
        }

        if (i >= size) {
            return values.subList(size - k, size);
        }

        int left = i - 1;
        int right = i;
        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < k; j++) {
            if (left >= 0 && (right >= size || Math.abs(values.get(left) - target) < Math.abs(values.get(right) - target))) {
                result.add(values.get(left));
                left--;
            } else {
                result.add(values.get(right));
                right++;
            }
        }

        return result;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            values.add(curr.val);
            curr = curr.right;
        }

    }
}