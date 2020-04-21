class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        if (s == null) {
            return result;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (isValid(curr)) {
                result.add(curr);
                found = true;
            }
            
            // this ensures once we've found a valid parentheses pattern, we don't do any further bfs using items pending in the queue since any further bfs would only yield strings of smaller length. However the items already in queue need to be processed since there could be other solutions of the same length.
            // And at any time, strings in queue will only differ in length of 1 (this is the implicit control)
            if (found) {
                continue;
            }
            
            for (int i = 0; i < curr.length(); i++) {
                char ch = curr.charAt(i);
                
                if (ch != '(' && ch != ')') {
                    continue;
                }
                
                if (i > 0 && ch == s.charAt(i - 1)) {
                    continue;
                }
                
                String next = curr.substring(0, i) + curr.substring(i + 1);
                
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        
        return count == 0;
    }
}