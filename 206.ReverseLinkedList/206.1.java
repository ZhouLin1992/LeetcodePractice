/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
    	return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode newHead) {
    	if (head == null) 
    		return newHead;
    	ListNode next = head.next;
    	head.next = newHead;
    	return reverseList(next, head);
    }
}