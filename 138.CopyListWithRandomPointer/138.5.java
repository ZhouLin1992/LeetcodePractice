/*
Recursive
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
    public Node copyRandomList(Node head) {
        if (head == null) {
        	return head;
        }

        Map<Node, Node> map = new HashMap<>();

        return copyRandomList(head, map);
    }

    private Node copyRandomList(Node head, Map<Node, Node> map) {
    	if (head == null) {
    		return null;
    	}

    	if (map.containsKey(head)) {
    		return map.get(head);
    	}

    	Node copy = new Node(head.val, null, null);
    	map.put(head, copy);

    	copy.next = copyRandomList(head.next, map);
    	copy.random = copyRandomList(head.random, map);

    	return copy;
    }
}