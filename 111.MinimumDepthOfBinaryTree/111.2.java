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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNodeHelper> queue = new LinkedList<>();
        queue.offer(new TreeNodeHelper(root, 1));
        int curDepth = 0;

        while (!queue.isEmpty()) {
            TreeNodeHelper pair = queue.poll();
        	curDepth = pair.depth;
        	TreeNode node = pair.node;

        	if (node.left == null && node.right == null) {
        		break;
        	}

        	if (node.left != null) {
        		queue.offer(new TreeNodeHelper(node.left, curDepth + 1));
        	}

        	if (node.right != null) {
        		queue.offer(new TreeNodeHelper(node.right, curDepth + 1));
        	}
        }
        
        return curDepth;
    }
    
    private class TreeNodeHelper {
        TreeNode node;
        int depth;
        TreeNodeHelper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}