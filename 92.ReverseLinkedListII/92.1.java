/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // the input is null or only has one element
		if (head == null || head.next == null) {
			return head;
		}

        // if n > m, the input command is wrong
        // if n == m, the input doesn't change
		if (n <= m) {
			return head;
		}
        
        // return result is dummy.next
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// start is the "m - 1" node
		int cnt = 0;
		ListNode start = dummy;
		while (cnt < m - 1) {
			start = start.next;
			cnt++;
		}

		// function for reversing node between [m, n]
		ListNode p1 = start.next;
		ListNode p2 = p1.next;
		cnt = m;
		while (cnt < n) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
			cnt++;
		}

		// Node(m - 1).next = n
		start.next.next = p2;

		// Node(m).next = n + 1
		start.next = p1;

		// return result
		return dummy.next;        
    }
}