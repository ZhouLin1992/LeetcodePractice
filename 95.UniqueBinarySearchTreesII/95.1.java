// recursion + brute force
// 卡特兰数

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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res = generateTrees(1, n);
        return res;
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        
        // return null if left > right
        // in this case, we can always jump into the loop below
        if (left > right) {
            res.add(null);
            return res;
        }
        
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftSubtree = generateTrees(left, i - 1);
            List<TreeNode> rightSubtree = generateTrees(i + 1, right);
            
            for (TreeNode lTree: leftSubtree) {
                for (TreeNode rTree: rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = lTree;
                    root.right = rTree;
                    res.add(root);                    
                }
            }
        }
        return res;
    }
}