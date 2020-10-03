class MyCalendarThree {
    Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();        
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            max = Math.max(count, max);
        }
        
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */