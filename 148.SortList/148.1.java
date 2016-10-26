/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
		    prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

        prev.next = null;
		ListNode l1 = sortList(slow);

		return merge(l1, sortList(head));
	}


	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), p = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return dummy.next;
    }
}