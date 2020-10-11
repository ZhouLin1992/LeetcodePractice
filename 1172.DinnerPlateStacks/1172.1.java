class DinnerPlates {
    private int capacity;
    private int left; // where to push element
    private int right; // where to pop element
    private int count; // number of elements
    private Map<Integer, Deque<Integer>> map;
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public void push(int val) {
        while (map.containsKey(left) && map.get(left).size() == capacity) {
            left++;
        }
        
        map.computeIfAbsent(left, stack -> new LinkedList<>()).push(val);
        count++;
        right = Math.max(left, right);
    }
    
    public int pop() {
        if (count == 0) {
            return -1;
        }
        
        while (right >=0 && map.get(right).size() == 0) {
            right--;
        }
        
        if (right == -1) {
            return -1;
        }
        
        count--;
        left = Math.min(left, right);
        return map.get(right).pop();
    }
    
    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).size() == 0) {
            return -1; 
        }
        
        left = Math.min(left, index);
        count--;
        return map.get(index).pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */