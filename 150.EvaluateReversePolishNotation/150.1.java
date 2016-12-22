public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        
        for (String str: tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                switch(str) {
                    case "+": stack.push(left + right); break;
                    case "-": stack.push(left - right); break;
                    case "*": stack.push(left * right); break;
                    case "/": stack.push(left / right); break;
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
}