class LFUCache {
    private int min;
    private final int capacity;
    
    private Map<Integer, Integer> keyToValue;
    private Map<Integer, Integer> keyToCount;
    private Map<Integer, LinkedHashSet<Integer>> countToKey;
    
    
    public LFUCache(int capacity) {
        min = 0;
        this.capacity = capacity;
        keyToValue = new HashMap<>();
        keyToCount = new HashMap<>();
        countToKey = new HashMap<>();
        countToKey.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        int count = keyToCount.get(key);
        keyToCount.put(key, count + 1);
        countToKey.get(count).remove(key);
        countToKey.computeIfAbsent(count + 1, k -> new LinkedHashSet<Integer>());
        countToKey.get(count + 1).add(key);
        
        if (min == count && countToKey.get(count).size() == 0) {
            min++;
        }
        
        return keyToValue.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key);
            return;
        }
        
        if (keyToValue.size() >= capacity) {
            evictKey();
        }
        
        min = 1;
        keyToValue.put(key, value);
        keyToCount.put(key, 1);
        countToKey.get(1).add(key);
    }
    
    private void evictKey() {
        int key = countToKey.get(min).iterator().next();
        keyToValue.remove(key);
        keyToCount.remove(key);
        countToKey.get(min).remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */