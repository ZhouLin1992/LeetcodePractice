/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Random rand;
    private ListNode head;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int sum = 1;
        ListNode fakeHead = head;
        ListNode res = fakeHead;
        while (fakeHead != null) {
            if (rand.nextInt(sum) == 0)
                res = fakeHead;
            fakeHead = fakeHead.next;
            sum++;
        }
        return res.val;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */