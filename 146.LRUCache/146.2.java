public class LRUCache {
	private Map<Integer, Integer> cache;
	private final int CAPACITY;
	public LRUCache(int capacity) {
		// (initialCapacity, loadFactor, accessOrder)
		// accessOrder - (default) false: insertion ordr
		// true: access order
		CAPACITY = capacity;
		cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return cache.size() > CAPACITY;
			}
		};
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		cache.put(key, value);
	}
}