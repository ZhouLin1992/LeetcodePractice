/*
Iterative
time: o(N)
space: o(1)
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    private void copyNext(Node head) {
        while (head != null) {
            Node newNode = new Node(head.val, null, null);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRandom(Node head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;                    
            }
            head = head.next.next;
        }
    }

    private Node splitList(Node head) {
        Node dummy = head.next;
        while (head != null) {
            Node tmp = head.next;
            head.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;                
            }
            head = head.next;
        }

        return dummy;
    }
}