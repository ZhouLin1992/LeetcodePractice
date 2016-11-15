/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode dummy = small;
		ListNode dummyLarge = large;
		ListNode pointer = head;
		while (pointer != null) {
			if (pointer.val < x) {
				small.next = pointer;
				small = small.next;
			} else {
				large.next = pointer;
				large = large.next;
			}
			pointer = pointer.next;
		}
		large.next = null;
		small.next = dummyLarge.next;
		return dummy.next;        
    }
}