/*
完全二叉树：如果左子树最左边的深度与右子树最右边的深度相等，
说明此完全二叉树为满二叉树，最后一层也是满的，则以该节点为
根的树其节点共有2^h-1个。如果不等于，则是左子树的节点数，
加上右子树的节点数，加上自身这一个。
Time Complexity: O(log(N)^2)
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
    public int countNodes(TreeNode root) {
        return countNodes(root, -1, -1);
    }
    
    private int countNodes(TreeNode root, int lheight, int rheight) {
        // if height of left subtree has not been calculated
        if (lheight == -1) {
            lheight = 0;
            TreeNode cur = root;
            while (cur != null) {
                lheight++;
                cur = cur.left;
            }
        }
        
        // if height of right subtree has not been calculated
        if (rheight == -1) {
            rheight = 0;
            TreeNode cur = root;
            while (cur != null) {
                rheight++;
                cur = cur.right;
            }
        }
        
        // height of left subtree and right subtree are the same
        // No. of nodes is 2^h - 1
        if (lheight == rheight) {
            return (1 << lheight) - 1;
        }
        
        // height is the same, No. of nodes is (left subtree nodes) + (right subtree nodes) + 1
        return countNodes(root.left, lheight - 1, -1) + countNodes(root.right, -1, rheight - 1) + 1;
    }
}