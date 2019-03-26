class LRUCache {
    private int capacity;
    private int size;
    private Map<Integer, ListNode> keyToPrev;
    private ListNode dummy;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToPrev = new HashMap<>();
        dummy = new ListNode(0, 0);
        tail = dummy;
    }

    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }

        // update use frequency in the cache (move to cache)
        moveToTail(key);

        return tail.val;
    }
    
    public void put(int key, int value) {
        // there is already key-value in the cache, update its value and move it to tail
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }

        // if the key-value pair is not in the cache and the cache has not exceeded its capacity yet
        if (size < capacity) {
            size++;
            ListNode curr = new ListNode(key, value);
            tail.next = curr;
            keyToPrev.put(key, tail);
            tail = curr;
            return;
        }

        // if the key-value pair is not in the cache and the cache has exceeded its capacity
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }

    // move the ListNode to the tail if it is recently used
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;

        if (tail == curr) {
            return;
        }

        // update affected ListNode
        prev.next = prev.next.next;
        tail.next = curr;

        // update key - prev ListNode pair in the map
        keyToPrev.put(key, tail);
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }

        tail = curr;
    }
}

// singly Linked List Node
class ListNode {
    int key;
    int val;
    ListNode next;
    public ListNode(int _key, int _val) {
        key = _key;
        val = _val;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */