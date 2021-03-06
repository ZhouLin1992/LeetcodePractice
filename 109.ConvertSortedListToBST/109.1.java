/*
time: o(NlogN)
space: o(logN) because we maintain a height balanced tree
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        return sortToBST(head, null);
    }
    
    private TreeNode sortToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortToBST(head, slow);
        root.right = sortToBST(slow.next, tail);
        
        return root;
    }
}