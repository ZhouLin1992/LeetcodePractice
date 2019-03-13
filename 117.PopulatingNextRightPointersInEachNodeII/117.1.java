/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        // first node of next level
        Node head = null;
        // the leading node of next level
        Node prev = null;
        // current node of current level
        Node curr = root;

        while (curr != null) {
            // traverse current level
            while (curr != null) {
                if (curr.left != null) {
                    // if there is no previous node, then the node is the first node of a level
                    if (prev == null) {
                        head = curr.left;
                    } else {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev == null) {
                        head = curr.right;
                    } else {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }

                curr = curr.next;
            }

            curr = head;
            head = null;
            prev = null;
        }

        return root;
    }
}