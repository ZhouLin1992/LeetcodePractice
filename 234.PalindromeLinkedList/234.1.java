public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head != null && head.next == null) return true;
		if (head == null) return true;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode front = head;
		ListNode tail = reverse(slow.next);

		while (tail != null) {
			if (front.val != tail.val) return false;
			front = front.next;
			tail = tail.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode next = head.next;
		ListNode fakeHead = null;
		while (head != null) {
			next = head.next;
			head.next = fakeHead;
			fakeHead = head;
			head = next;
		}
		return head;
	}
}