/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
	    ListNode dummy = head;
		while (dummy != null && dummy.next != null) {
			if (dummy.val == dummy.next.val) {
				dummy.next = dummy.next.next;
			} else {
			    dummy = dummy.next;    
			}
		} 
		return head;
    }
}