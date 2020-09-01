class TimeMap {
    private Map<String, List<Item>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, val -> new ArrayList<>()).add(new Item(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Item> list = map.get(key);
        if (list == null) {
            return "";
        }
        
        return binarySearch(list, timestamp);
    }
    
    private String binarySearch(List<Item> list, int timestamp) {
        int lo = 0;
        int hi = list.size() - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            } else if (list.get(mid).timestamp < timestamp) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return list.get(hi).timestamp <= timestamp ? list.get(hi).value : (list.get(lo).timestamp <= timestamp ? list.get(lo).value : "");
    }
}

class Item {
    public String value;
    public int timestamp;
    
    public Item(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */