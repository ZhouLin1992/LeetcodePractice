class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return new ArrayList<>();
        }
        
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> list : tickets) {
            map.computeIfAbsent(list.get(0), queue -> new PriorityQueue<>()).offer(list.get(1));
        }
        
        List<String> result = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            result.add(0, stack.pop());
        }
        
        return result;
    }
}