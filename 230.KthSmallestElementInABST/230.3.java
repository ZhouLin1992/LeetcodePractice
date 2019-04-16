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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        kthSmallest(root, k, result);
        return result.get(k - 1);
    }

   	private void kthSmallest(TreeNode root, int k, List<Integer> result) {
   		if (result.size() >= k) {
   			return;
   		}

   		if (root.left != null) {
   			kthSmallest(root.left, k, result);
   		}
   		result.add(root.val);
   		if (root.right != null) {
   			kthSmallest(root.right, k, result);
   		}
   	}
}