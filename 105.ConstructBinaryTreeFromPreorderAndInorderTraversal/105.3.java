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
		if (preorder == null || preorder.length == 0) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);

		for (int i = 1; i < preorder.length; i++) {
			int val = preorder[i];
			TreeNode node = new TreeNode(val);

			/*
			In the inorder array, the index of the current value is on the left of the last node,
			so it must be its left child
			*/
			if (map.get(val) < map.get(stack.peek().val)) {
				stack.peek().left = node;
			/*
			In the inorder array, the index of the current value is on the right of the last node,
			so it must be the right child of either the last node or one of the last node's ancestors
			*/	
			} else {
				TreeNode parent = null;
				while (!stack.isEmpty() && map.get(val) > map.get(stack.peek().val)) {
					parent = stack.pop();
				}
				parent.right = node;
			}
			stack.push(node);
		}

		return root;
    }
}