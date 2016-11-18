/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// top-down method: divide and conquer
// use binary tree to analyze time complexity

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}

		int len = lists.length;

		if (len == 0) {
			return null;
		}

		if (len == 1) {
			return lists[0];
		}

		return sort(lists, 0, len - 1);
	}

	private ListNode sort(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		}

		// divide
		int mid = start + (end - start) / 2;
		ListNode left = sort(lists, start, mid);
		ListNode right = sort(lists, mid + 1, end);

		// conquer
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				pointer.next = left;
				left = left.next;
			} else {
				pointer.next = right;
				right = right.next;
			}
			pointer = pointer.next;
		}
		pointer.next = left == null ? right : left;
		return dummy.next;
	}
}