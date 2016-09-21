/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) return null;

    	int lenA = length(headA);
    	int lenB = length(headB);
    	ListNode p1 = headA;
    	ListNode p2 = headB;

    	while (lenA > lenB) {
    		p1 = p1.next;
    		lenA--; 
    	}

    	while (lenA < lenB) {
    		p2 = p2.next;
    		lenB--;
    	}

    	while (p1 != p2) {
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return p1;
    }
    
 	private int length(ListNode head) {
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		return len;
    }   
}