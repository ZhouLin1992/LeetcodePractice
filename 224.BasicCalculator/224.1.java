/* 
初始number, result = 0, sign = 1, 开始遍历字符串:

碰到数字则追加到number尾端
碰到加号说明上一个数字已经完全被计算至number, 这时应该把number * sign加到result中, 然后把sign置为1 (因为当前碰到了加号)
碰到减号, 同上, 不同的在于最后要把sign置为-1
碰到左括号, 说明这时要优先出右边的表达式, 需要将result和sign压入栈中(注意, 此时的sign表示的是这个括号内的表达式应该被result加上还是减去), 然后初始化result和sign, 准备计算括号内的表达式
碰到右括号, 说明一个括号内的表达式被计算完了, 此时需要从栈中取出该括号之前的sign和result, 与当前的result相加运算 (注意, 是原来的result + sign * 当前result)
注意, 一个合法的表达式, 左括号之前一定不会是数字, 右括号之前一定是一个数字. 所以碰到右括号不要忘了先把number * sign加到当前result里.

以及, 循环结束后number可能还有数字, 需要加到result里. (比如"1+2"这样的表达式, 2并不会在循环内被加到结果中)
*/

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