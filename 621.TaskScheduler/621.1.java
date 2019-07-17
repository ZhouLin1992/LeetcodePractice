class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n < 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> e1.getKey() != e2.getKey() ? e2.getValue() - e1.getValue() : e1.getKey() - e2.getKey());
        queue.addAll(map.entrySet());

        int count = 0;
        while (!queue.isEmpty()) {
            // interval
            int k = n + 1;
            List<Map.Entry<Character, Integer>> temp = new LinkedList<>();
            while (k > 0 && !queue.isEmpty()) {
                // most frequently task
                Map.Entry<Character, Integer> entry = queue.poll();
                // update frequency
                entry.setValue(entry.getValue() - 1);
                // collect task to add back to queue
                temp.add(entry);
                k--;
                // successfully excute task
                count++;
            }
            
            for (Map.Entry<Character, Integer> e : temp) {
                // add valid tasks
                if (e.getValue() > 0) {
                    queue.add(e);
                }
            }

            if (queue.isEmpty()) {
                break;
            }
            // if k > 0, it means that some slots should be idle
            count += k;
        }
        return count;
    }
}