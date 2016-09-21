public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode faster = head;
    	ListNode slower = head;

    	for (int i = 0; i < n; i++) faster = faster.next;
    	if (faster == null) return head.next;

    	while (faster.next != null) {
    		slower = slower.next;
    		faster = faster.next;
    	}
    	slower.next = slower.next.next;
    	return head;
    }
}