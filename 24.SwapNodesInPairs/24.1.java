/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        
        while (temp.next != null && temp.next.next != null) {
            ListNode one = temp.next;
            ListNode two = temp.next.next;
            one.next = two.next;
            two.next = one;
            temp.next = two;
            // temp.next.next = one;
            // temp = temp.next.next;
            temp = one;
        }
        return dummy.next;
    }
}