class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }

        // corner case
        int len = num.length();
        if (len == k) {
            return "0";
        }
        
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        
        // corner case: "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.reverse().toString();
    }
}