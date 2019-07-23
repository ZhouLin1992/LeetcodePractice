/*
Time: o(NlogN) If the tree is balanced, then at each recursion, we reduce the size of the array we are looking in to find the next max value in half.
Worse Time: O(N^2) if it is monotonically increasing or decreasing
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

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int indexMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[indexMax]) {
                indexMax = i;
            }
        }

        TreeNode root = new TreeNode(nums[indexMax]);
        root.left = buildTree(nums, start, indexMax - 1);
        root.right = buildTree(nums, indexMax + 1, end);

        return root;
    }
}