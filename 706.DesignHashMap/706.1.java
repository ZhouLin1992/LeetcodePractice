class MyHashMap {
    
    ListNode[] nodes;

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode node = findElement(getIndex(key), key);
        if (node.next == null) {
            node.next = new ListNode(key, value);
        } else {
            node.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode node = findElement(getIndex(key), key);
        if (node.next == null) {
            return -1;
        }
        return node.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode node = findElement(getIndex(key), key);
        if (node.next != null) {
            node.next = node.next.next;
        }
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    private ListNode findElement(int index, int key) {
        if (nodes[index] == null) {
            return nodes[index] = new ListNode(-1, -1);
        }
        
        ListNode prev = nodes[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        return prev;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    
    public ListNode(int _key, int _value) {
        key = _key;
        value = _value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */