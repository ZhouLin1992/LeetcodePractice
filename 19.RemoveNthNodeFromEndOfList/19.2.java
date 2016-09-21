public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fakeHead = new ListNode(0);
    	fakeHead.next = head;
    	ListNode faster = fakeHead;
    	ListNode slower = fakeHead;

    	for (; faster.next != null; n--) {
    		faster = faster.next;
    		if (n <= 0) slower = slower.next;
    	}
    	slower.next = slower.next.next;
    	return fakeHead.next;
    }
}