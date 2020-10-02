class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        // the start of the interval
        int prev = 0;

        for (String str : logs) {
            String[] split = str.split(":");
            int id = Integer.parseInt(split[0]);
            String flag = split[1];
            int timestamp = Integer.parseInt(split[2]);
            
            if (flag.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += timestamp - prev;
                }
                // timestamp is the start of the next interval, doesn't belong to the current interval
                prev = timestamp;
                stack.push(id);
            } else {
                // timestamp is the end of the current interal, belong to the current interval
                res[stack.pop()] += timestamp - prev + 1;
                // add +1 for the next interval
                prev = timestamp + 1;
            }
        }
        
        return res;
    }
}