/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode cur = dummy;
            
            // <= not <, keep the algorithm stable
            // 因为假如有2个数相同，后面的数后找到，也要插入到后面才可以。也就是说当=的时候，是继续往下走
            while (cur.next != null && cur.next.val <= head.val) {
                cur = cur.next;
            }
            
            // unlink the node from the original position, and record the next position
            ListNode next = head.next;
            head.next = cur.next;
            
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }
}