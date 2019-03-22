/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		List<Node> nodes = getAllNodes(node);
		Map<Node, Node> map = new HashMap<>();

		for (Node ele : nodes) {
			Node newNode = new Node(ele.val, new LinkedList<Node>());
			map.put(ele, newNode);
		}

		for (Node ele : nodes) {
			Node newNode = map.get(ele);
			for (Node neighbor : ele.neighbors) {
				newNode.neighbors.add(map.get(neighbor));
			}
		}

		return map.get(node);
    }

    private List<Node> getAllNodes(Node node) {
    	Queue<Node> queue = new LinkedList<>();
    	Set<Node> set = new HashSet<>();
    	List<Node> list = new LinkedList<>();

    	queue.offer(node);
    	set.add(node);
    	list.add(node);

    	while (!queue.isEmpty()) {
    		Node curr = queue.poll();

    		for (Node neighbor : curr.neighbors) {
    			if (set.add(neighbor)) {
    				queue.offer(neighbor);
    				list.add(neighbor);
    			}
    		}
    	}

    	return list;
    }
}