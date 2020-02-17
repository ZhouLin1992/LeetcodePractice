/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        // root自成一个环
        root.left = root;
        root.right = root;

        // left部分自成环/root自成一环/right部分自成环 进行组合
        return connet(connet(leftHead, root), rightHead);
    }
    
    private Node connet(Node n1, Node n2) {
        // 若其中一个环为null 则返回另外一个环
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        // tail1不是n1.right 因为一个环里可能有很多元素 所以tail1应该是n1.left
        Node tail1 = n1.left;
        Node tail2 = n2.left;

        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;
        
        return n1;
    }
}