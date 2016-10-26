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

		// get the length of the list
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left, right, tail;
		for (int step = 1; step < len; step <<= 1) {
			cur = dummy.next;
			tail = dummy;
			while (cur != null) {
				left = cur;
				right = split(left, step);
				cur = split(right, step);
				tail = merge(left, right, tail);
			}
		}
		return dummy.next;
	}

	public ListNode split(ListNode head, int n) {
		for (int i = 1; head != null && i < n; i++)
			head = head.next;
		if (head == null) return null;
		ListNode second = head.next;
		head.next = null;
		return second;
	}

	public ListNode merge(ListNode l1, ListNode l2, ListNode head) {
		ListNode fakeHead = head;

		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				fakeHead.next = l1;
				fakeHead = fakeHead.next;
				l1 = l1.next;
			} else {
				fakeHead.next = l2;
				fakeHead = fakeHead.next;
				l2 = l2.next;
			}
		}
		fakeHead.next = l1 == null ? l2 : l1;
		while (fakeHead.next != null) fakeHead = fakeHead.next;
		return fakeHead;
    }
}