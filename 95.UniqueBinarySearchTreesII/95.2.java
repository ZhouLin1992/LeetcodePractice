// DP + Memorization

/*
result[i] stores the result until length i. For the result for length i+1, 
select the root node j from 0 to i, combine the result from left side and right side. 
Note for the right side we have to clone the nodes as the value will be offsetted by j.
*/

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
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            for (int i = 0; i < len; i++) {
                // left tree length range: [0, len - 1]
                for (TreeNode lTree: dp[i]) {
                    // right tree length range: [len - 1, 0]
                    // len - i - 1 means that length - (number of TreeNodes of left tree) - root (1)
                    for (TreeNode rTree: dp[len - i - 1]) {
                        // left subtree length = i
                        TreeNode root = new TreeNode(i + 1);
                        root.left = lTree;
                        // right subtree starts from rTree.val + i + 1
                        root.right = clone(rTree, i + 1);
                        dp[len].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    
    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
}