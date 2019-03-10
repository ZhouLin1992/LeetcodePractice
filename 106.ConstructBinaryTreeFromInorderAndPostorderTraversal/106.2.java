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
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		stack.push(root);

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		for (int i = postorder.length - 2; i >= 0; i--) {
			int val = postorder[i];
			TreeNode node = new TreeNode(val);
			if (!stack.isEmpty() && map.get(val) > map.get(stack.peek().val)) {
				stack.peek().right = node;
			} else {
				TreeNode parent = null;
				while (!stack.isEmpty() && map.get(val) < map.get(stack.peek().val)) {
					parent = stack.pop();
				}
				parent.left = node;
			}
			stack.push(node);
		}

		return root;
    }
}