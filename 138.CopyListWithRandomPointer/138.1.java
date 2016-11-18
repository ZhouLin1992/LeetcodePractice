/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		// 1 -> 2 -> 3  ==> 1 -> 1' -> 2 -> 2' -> 3 -> 3'
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;		
		while (head != null) {
			RandomListNode newListNode = new RandomListNode(head.label);
			newListNode.next = head.next;
			head.next = newListNode;
			head = newListNode.next;
		}

		// copy random
		RandomListNode fakeHead = dummy.next;
		while (fakeHead != null) {
			RandomListNode copy = fakeHead.next;
			if (fakeHead.random == null) {
			    copy.random = null;
			} else {
			    copy.random = fakeHead.random.next;			    
			}
			fakeHead = copy.next;
		}

		// split one ListNode tail into two ListNode tails
		RandomListNode pointer = dummy;
		RandomListNode newHead = dummy.next;
		while (newHead != null) {
			pointer.next = newHead.next;
			pointer = pointer.next;
			newHead.next = pointer.next;
			newHead = newHead.next;
		}

		return dummy.next;        
    }
}