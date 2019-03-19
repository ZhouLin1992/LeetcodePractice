/*
Iterative
time: o(N)
space: o(N)
*/

/*
time: o(N)
space: o(N)
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
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldHead = head;
        Node newHead = new Node(head.val, null, null);
        map.put(oldHead, newHead);

        while (oldHead != null) {
            newHead.next = getClonedNode(oldHead.next);
            newHead.random = getClonedNode(oldHead.random);

            oldHead = oldHead.next;
            newHead = newHead.next;
        }

        return map.get(head);
    }
    
    private Node getClonedNode(Node head) {
        if (head == null) {
            return null;
        }

        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null, null);
        map.put(oldNode, newNode);

        return newNode;
    }
}