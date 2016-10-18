/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		ListNode tmp = new ListNode(0);
		tmp.next = head;
		int len = 0;
		while (tmp.next != null) {
			tmp = tmp.next;
			len++;			
		}
		k %= len;
		if (k == 0) return head;
		int pos = len - k;
		ListNode pointer = head;
		while (pos-- > 1) 
			pointer = pointer.next;
		tmp.next = head;
		head = pointer.next;
		pointer.next = null;
		return head;
    }
}