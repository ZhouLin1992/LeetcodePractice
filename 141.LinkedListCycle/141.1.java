/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
		ListNode slower = head;
		ListNode faster = head;

		while (faster != null && faster.next != null) {
			faster = faster.next.next;
			slower = slower.next;

			if (faster == slower)
				return true;
		}
		return false;
    }
}