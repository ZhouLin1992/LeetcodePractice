/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode one = dummy, two = dummy.next;
		while (two != null) {
			if (two.val == val) one.next = two.next;
			else one = one.next;
			two = two.next;
		}
		return dummy.next;
    }
}