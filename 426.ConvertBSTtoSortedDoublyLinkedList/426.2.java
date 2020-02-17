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
        
        Node first = null;
        Node last = null;
        
        Deque<Node> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();

            // 得到list的开头
            if (first == null) {
                first = root;
            }

            // 开始建list
            if (last != null) {
                last.right = root;
                root.left = last;
            }

            last = root;
            root = root.right;
        }
        
        // 注意是first的左边是last, last的右边是first
        first.left = last;
        last.right = first;
        
        return first;
    }
}