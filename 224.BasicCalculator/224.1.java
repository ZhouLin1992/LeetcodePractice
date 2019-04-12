class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = 10 * number + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (ch == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (ch == '(') {
                // push result first, then push sign
                stack.push(result);
                stack.push(sign);

                // reset the sign and result for the value in the parenthesis
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                // stack.pop() is the sign before the parenthesis
                result *= stack.pop();
                // stack.pop() is the result calculated before the parenthesis
                result += stack.pop();
                number = 0;
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}