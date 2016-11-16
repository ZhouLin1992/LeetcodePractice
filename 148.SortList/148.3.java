public class Solution {
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = findMiddle(head);

		// quick sort partition (similar to partition list)
		ListNode leftDummy = new ListNode(0), left = leftDummy;
		ListNode rightDummy = new ListNode(0), right = rightDummy;
		ListNode middleDummy = new ListNode(0), middle = middleDummy;
		ListNode pointer = head;

		while (pointer != null) {
			if (pointer.val < mid.val) {
				left.next = pointer;
				left = left.next;
			} else if (pointer.val > mid.val) {
				right.next = pointer;
				right = right.next;
			} else {
				middle.next = pointer;
				middle = middle.next;
			}
			pointer = pointer.next;
		}

		left.next = null;
		right.next = null;
		middle.next = null;

		ListNode l = sortList(leftDummy.next);
		ListNode r = sortList(rightDummy.next);

		return merge(l, middleDummy.next, r);
	}

	private ListNode merge(ListNode left, ListNode middle, ListNode right) {
		ListNode dummy = new ListNode(0), tail = dummy;

		if (left != null) {
			tail.next = left;
			tail = getTail(left);
		}

		if (middle != null) {
			tail.next = middle;
			tail = getTail(middle);
		}

		if (right != null) {
			tail.next = right;
		}

		return dummy.next;
	}

	private ListNode getTail(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		while (head.next != null) {
			head = head.next;
		}

		return head;
	}
}