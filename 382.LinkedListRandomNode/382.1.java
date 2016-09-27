/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Random rand = new Random();
    private ListNode fakeHead;
    private ListNode head;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int sum = 1;
        fakeHead = head;
        int res = fakeHead.val;
        while (fakeHead != null) {
            if (randInt(sum) == sum)
                res = fakeHead.val;
            sum++;
            fakeHead = fakeHead.next;
        }
        return res;
    }
    
    private int randInt(int i) {
        return 1 + rand.nextInt(i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */