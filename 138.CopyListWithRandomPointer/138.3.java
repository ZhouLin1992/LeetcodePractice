/*
Polish 138.2
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
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0, null, null);
        Node prev = dummy;
        Node newNode;

        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new Node(head.val, null, null);
                map.put(head, newNode);
            }
            prev.next = newNode;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    Node random = new Node(head.random.val, null, null);
                    map.put(head.random, random);
                    newNode.random = random;
                }
            }

            head = head.next;
            prev = newNode;
        }

        return dummy.next;
    }
}