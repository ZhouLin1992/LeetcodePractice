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
		return addTwoNumbers(l1, l2, 0);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if (l1 == null)
			return carry == 0 ? l2 : addTwoNumbers(new ListNode(carry), l2, 0);

		if (l2 == null)
			return carry == 0 ? l1 : addTwoNumbers(l1, new ListNode(carry), 0);

		int sum = l1.val + l2.val + carry;
		ListNode cur = new ListNode(sum % 10);
		cur.next = addTwoNumbers(l1.next, l2.next, sum / 10);
		return cur;
    }
}