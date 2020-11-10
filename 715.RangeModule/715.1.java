class RangeModule {
    TreeMap<Integer, Integer> map;
    
    public RangeModule() {
        map = new TreeMap<>();    
    }
    
    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else if (start != null && map.get(start) >= left) {
            map.put(start, Math.max(map.get(start), Math.max(right, map.get(end))));
        } else {
            map.put(left, Math.max(map.get(end), right));
        }
        
        // clean up
        map.subMap(left, false, right, true).clear();
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start == null) {
            return false;
        }
        return map.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        // Need to check 'end' before 'start': Because start and end can be the same value. In this case if you do [map.put(start, left)] at first it changes the range, which causes the condition test [map.get(end) > right] fail
        if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
        }
        if (start != null && map.get(start) > left) {
            map.put(start, left);
        }
        
        // clean up
        map.subMap(left, true, right, false).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */