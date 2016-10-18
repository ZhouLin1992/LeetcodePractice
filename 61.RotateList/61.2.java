/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		ListNode tmp = head, fast = head, slow = head;
		int count = 1;
		while (tmp.next != null) {
			tmp = tmp.next;
			count++;			
		}
		tmp.next = head;
		k %= count;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast != tmp) {
			fast = fast.next;
			slow = slow.next;
		}
		head = slow.next;
		slow.next = null;
		return head;     
    }
}