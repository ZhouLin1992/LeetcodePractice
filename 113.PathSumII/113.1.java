/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        
        pathSumHelper(result, sub, root, sum);
        return result;
    }
    
    private void pathSumHelper(List<List<Integer>> result, List<Integer> sub, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        sum -= root.val;
        
        if (root.left == null && root.right == null) {
            // it is already at the leaf node
            if (sum == 0) {
                sub.add(root.val);
                result.add(new ArrayList<Integer>(sub));
                // backtracking
                sub.remove(sub.size() - 1);
            }
            return;
        }
        
        sub.add(root.val);
        pathSumHelper(result, sub, root.left, sum);
        pathSumHelper(result, sub, root.right, sum);
        sub.remove(sub.size() - 1);
    }
}