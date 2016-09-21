/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) p1 = p1.next;
        if (p1 == null) return head.next;
        
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode p3 = head;
        while (p3.next != p2) {
            p3 = p3.next;
        }
        p3.next = p3.next.next;
        return head;
    }
}