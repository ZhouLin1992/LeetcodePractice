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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        Queue<myNode> queue = new LinkedList<>();
        int left = 0, right = nums.length - 1;
        int m = left + (right - left) / 2;
        int val = nums[m];
        TreeNode root = new TreeNode(val);
        queue.offer(new myNode(root, left, right));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                myNode cur = queue.poll();
                
                int mid = cur.left + (cur.right - cur.left) / 2;
                
                if (mid != cur.left) {
                    int l = cur.left + (mid - 1 - cur.left) / 2;
                    TreeNode leftNode = new TreeNode(nums[l]);
                    cur.node.left = leftNode;
                    queue.offer(new myNode(leftNode, cur.left, mid - 1));                    
                }
                
                if (mid != cur.right) {
                    int r = mid + 1 + (cur.right - mid - 1) / 2;
                    TreeNode rightNode = new TreeNode(nums[r]);
                    cur.node.right = rightNode;
                    queue.offer(new myNode(rightNode, mid + 1, cur.right));
                }
            }
        }
        
        return root;
    }
}

class myNode {
    TreeNode node;
    int left, right;
    public myNode(TreeNode node, int left, int right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }
}