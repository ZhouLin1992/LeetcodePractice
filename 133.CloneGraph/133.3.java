/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newNode = visited.get(curr);
            for (Node nei : curr.neighbors) {
                if (!visited.containsKey(nei)) {
                    Node newNei = new Node(nei.val, new ArrayList<>());
                    visited.put(nei, newNei);
                    queue.offer(nei);
                }
                newNode.neighbors.add(visited.get(nei));
            }
        }
        
        return visited.get(node);
    }
}