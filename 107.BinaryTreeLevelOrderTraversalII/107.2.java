// DFS

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottom(result, root, 1);
        return result;
    }
    
    private void levelOrderBottom(List<List<Integer>> result, TreeNode cur, int level) {
        if (cur == null) {
            return;
        }
        
        if (level > result.size()) {
            result.add(0, new LinkedList<Integer>());
        }
        
        levelOrderBottom(result, cur.left, level + 1);
        levelOrderBottom(result, cur.right, level + 1);
        result.get(result.size() - level).add(cur.val);
    }
}