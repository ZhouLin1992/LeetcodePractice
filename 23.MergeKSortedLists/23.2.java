// bottom-up method: merge lists two by two
// time complexity is O(Nlogk)
// imagine a binary tree and each node in the binary tree is a ListNode tail
// the height of the binary tree is logk, and at each level, we need to merge N nodes
// so the time complexity is O(N) * logk

public class Solution {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		if (lists.size() == 1) {
			return lists.get(0);
		}

		while (lists.size() > 1) {
			List<ListNode> newList = new ArrayList<>();
			for (int i = 0; i + 1 < lists.size(); i += 2) {
				ListNode mergeList = merge(lists.get(i), lists.get(i + 1));
				newList.add(mergeList);
			}
			if (lists.size() % 2 == 1) {
				newList.add(lists.get(lists.size() - 1));
			}
			lists = newList;
		}

		return newList.get(0);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode pointer = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				pointer.next = l1;
				l1 = l1.next;
			} else {
				pointer.next = l2;
				l2 = l2.next;
			}
			pointer = pointer.next;
		}

		pointer.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}