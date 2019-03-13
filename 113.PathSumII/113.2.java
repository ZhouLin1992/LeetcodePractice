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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<>();
		if (root == null) {
			return result;
		}

		List<Integer> path = new ArrayList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode prev = null;
		TreeNode curr = root;
		// sum along the current path
		int pathSum = 0;

		while (curr != null || !stack.isEmpty()) {
			/*
			go down all the way to the left leaf node
			add all the left nodes to the stack
			*/
			while (curr != null) {
				stack.push(curr);
				// record the current sum along the current path
				pathSum += curr.val;
				// record the current path
				path.add(curr.val);
				curr = curr.left;
			}

			curr = stack.peek();

			/*
			check left leaf node's right subtree
			or check if it is not from the right subtree
			*/ 
			if (curr.right != null && curr.right != prev) {
				curr = curr.right;
				// back to the outer while loop
				continue;
			}

			if (curr.left == null && curr.right == null) {
				if (pathSum == sum) {
					result.add(new ArrayList<Integer>(path));
				}
			}

			stack.pop();
			// for the use to check if the previous node is from right subtree
			prev = curr;
			pathSum -= curr.val;
			path.remove(path.size() - 1);
			// reset current node to null, so check the next item from the stack
			curr = null;
		}

		return result;
    }
}