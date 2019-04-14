// not use stack
// https://leetcode.com/problems/basic-calculator-ii/discuss/62996/Java-straight-forward-iteration-Solution-with-comments-No-Stack-O(N)-and-O(1)

class Solution {
    public int calculate(String s) {
        int result = 0;
        int prev = 0;
        char sign = '+';
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == ' ' || ch == '\t') {
                continue;
            }

            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + s.charAt(i + 1) - '0';
                    i++;
                }

                if (sign == '+') {
                    result += prev;
                    prev = num;
                } else if (sign == '-') {
                    result += prev;
                    prev = -num;
                } else if (sign == '*') {
                    prev *= num;
                } else if (sign == '/') {
                    prev /= num;
                }
            } else {
                sign = ch;
            }
        }

        result += prev;
        return result;
    }
}