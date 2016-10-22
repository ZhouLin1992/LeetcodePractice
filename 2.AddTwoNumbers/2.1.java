/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode last = head;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int add = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = add / 10;
            cur.val = add % 10;
            last.next = cur;
            last = cur;
            
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }
}