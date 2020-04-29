class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                String curr = queue.poll();
                
                if (deadEndSet.contains(curr)) {
                    size--;
                    continue;
                }
                
                if (curr.equals(target)) {
                    return level;
                }
                
                for (int i = 0; i < 4; i++) {
                    char currChar = curr.charAt(i);
                    String next1 = curr.substring(0, i) + (currChar == '9' ? 0 : currChar - '0' + 1) + curr.substring(i + 1);
                    String next2 = curr.substring(0, i) + (currChar == '0' ? 9 : currChar - '0' - 1) + curr.substring(i + 1);
                    
                    if (!visited.contains(next1) && !deadEndSet.contains(next1)) {
                        visited.add(next1);
                        queue.offer(next1);
                    }
                    
                    if (!visited.contains(next2) && !deadEndSet.contains(next2)) {
                        visited.add(next2);
                        queue.offer(next2);
                    }
                }
                size--;
            }
            level++;
        }
        
        return -1;
    }
}