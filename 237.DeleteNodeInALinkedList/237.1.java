/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode tmp = node.next;
		node.val = node.next.val;
		node.next = node.next.next;
		tmp = null;
    }
}