/**
time: O(2 ^ (l + r))
space: O((l + r) ^ 2) ~ O(n^2) 递归深度 * 字符串长度
http://zxi.mytechroad.com/blog/string/leetcode-301-remove-invalid-parentheses/
**/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;
        int r = 0;
        
        // compute minumim number of parentheses to remove (unbalanced 左括号和右括号)
        for (char ch : s.toCharArray()) {
            // 假设左括号是多余的
            if (ch == '(') {
                l++;
            }
            // 如果此时没有左括号可以匹配
            if (l == 0) {
                // 且遇见右括号
                if (ch == ')') {
                    // 右括号需要被删除
                    r++;
                }
            // 如果此时有左括号可以匹配
            } else {
                // 且遇见右括号
                if (ch == ')') {
                    // 左括号可以被抵消
                    l--;
                }
            }
        }
        
        List<String> result = new LinkedList<>();
        helper(s, result, 0, l, r);
        return result;
    }
    
    private boolean isValid(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            // ')' 比 '('多
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // try all possible ways to remove parentheses
    private void helper(String s, List<String> result, int start, int l, int r) {
        // nothing to remove
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            // We only remove the first parenthes if there are consecutive ones to avoid duplications.
            if (i > start && ch == s.charAt(i - 1)) {
                continue;
            }
            
            // check当前字符是否为括号
            if (ch == '(' || ch == ')') {
                String next = s.substring(0, i) + s.substring(i + 1);
                // 先移除右括号让prefix valid
                if (r > 0 && ch == ')') {
                    helper(next, result, i, l, r - 1);
                }
                if (l > 0 && ch == '(') {
                    helper(next, result, i, l - 1, r);
                }
            }
        }
    }
}