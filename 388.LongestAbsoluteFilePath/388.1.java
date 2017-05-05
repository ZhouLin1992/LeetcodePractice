// Just pay attention that in String "\n", "\t", "\123" will all be count the length as one

public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        String[] parts = input.split("\n");
        int result = 0;
        for (String str: parts) {
            // count number of "\t"
            int level = str.lastIndexOf("\t") + 1;
            int len = str.length() - level;
            while (stack.size() > level + 1) {
                stack.pop();
            }
            
            if (str.contains(".")) {
                result = Math.max(result, stack.peek() + len);
            } else {
                stack.push(stack.peek() + len + 1);
            }
        }
        return result;
    }
}