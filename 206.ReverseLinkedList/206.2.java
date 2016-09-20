public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newHead = null;
		ListNode next;
		while (head != null) {
			next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}