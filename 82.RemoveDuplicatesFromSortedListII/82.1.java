/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// try to remove the duplicates first and then
// point "head.next" to the non-duplicates;
// the node that "head" is pointing to has already
// been dealt with
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} 

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int val = head.next.val;
				while (head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}

		return dummy.next;        
    }
}