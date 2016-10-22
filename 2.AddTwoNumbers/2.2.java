/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int carry = 0;
		ListNode last = dummy;
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}

			last.next = new ListNode(carry % 10);
			last = last.next;
			carry /= 10;
		}
		return dummy.next;
    }
}