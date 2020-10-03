/**
Think of this as "scanning" from left to right with a "vertical laser". 
Every endpoint (a start point, or an end point) is an event. 
A start point is +1, an end point is -1. 
The accumulated value "count" would be the number of "active" intervals 
which is cut by the vertical laser.
**/

class MyCalendarTwo {
    Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;

        // return the entries in ascending key order
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                map.put(start, map.get(start) - 1);
                // if map.get(start) == 0, remove this key from map
                map.remove(start, 0);
                
                map.put(end, map.get(end) + 1);
                // if map.get(end) == 0, remove this key from map
                map.remove(end, 0);
                
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */