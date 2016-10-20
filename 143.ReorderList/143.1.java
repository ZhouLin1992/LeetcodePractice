/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;

		// find the mid element
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse second half, head is p1
		ListNode p1 = slow.next, p2 = slow.next.next, tmp;
		p1.next = null;
		slow.next = null;
		while (p2 != null) {
			tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}

		// concatenate two parts of list
		ListNode c1 = head, c2 = p1, tmp1, tmp2;
		while (c2 != null) {
			tmp1 = c1.next;
			c1.next = c2;
			tmp2 = c2.next;
			c2.next = tmp1;
			c1 = tmp1;
			c2 = tmp2;
		}

    }
}