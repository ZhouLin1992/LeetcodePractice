/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// space: O(N)

public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> hashmap = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode = new RandomListNode(0);
        
        while (head != null) {
            if (hashmap.containsKey(head)) {
                newNode = hashmap.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                hashmap.put(head, newNode);
            }
        
            pre.next = newNode;
            
            if (head.random != null) {
                if (hashmap.containsKey(head.random)) {
                    newNode.random = hashmap.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    hashmap.put(head.random, newNode.random);
                }
            }
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}