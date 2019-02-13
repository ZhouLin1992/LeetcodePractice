// http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode pointer = head;
        int i = 0;
        
        while (pointer != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, pointer.next);
                pointer = prev.next;
            } else {
                pointer = pointer.next;
            }
        }
        
        return dummy.next;
    }
    
    // reverse a single linked list
    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}