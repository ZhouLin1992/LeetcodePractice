public class LRUCache {
	// Map(key, Node): storing key and the storage address, time complexity of get() is O(N)
	// LinkedList(key, Node, prev, next): a deletion ranking Doubly-LinkedList
	// time complexity of nodes adding/removal is O(1)
	// the deletion node is at the head and the recent visited
	// node is at the tail

	private Map<Integer, Node> map;
	private int capacity;
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);

	// during initailization:
	public LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		// reconstruct the LinkedList
		Node curt = map.get(key);
		curt.prev.next = curt.next;
		curt.next.prev = curt.prev;

		// move the current node to tail
		move_to_tail(curt);

		return map.get(key).value;
	}

	public void set(int key, int value) {
		// if key is already in the hashmap
		// update its value
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}

		// if the key is not in the hashmap
		// the hashmap size arrives at the capacity
		// remove the least recent node at the head of the LinkedList
		if (map.size() == capacity) {
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}

		// new node needs to be added at the tail
		Node newNode = new Node(key, value);
		map.put(key, newNode);
		move_to_tail(newNode);
	}

	private void move_to_tail(Node node) {
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
		node.next = tail;
	}
}

class Node {
	int key;
	int value;
	Node prev;
	Node next;
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}