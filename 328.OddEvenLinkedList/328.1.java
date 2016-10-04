/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return head;
		ListNode fakeOdd = head;
		ListNode fakeEven = head.next;
		ListNode odd = head, even = head.next;
		while (even != null) {
			if (even.next == null) {
				break;
			}
			if (odd.next == null) {
				even.next = null;
				break;
			}
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = fakeEven;
		return fakeOdd;        
    }
}