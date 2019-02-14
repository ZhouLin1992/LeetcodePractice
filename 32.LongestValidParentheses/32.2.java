/*
use stack:
refer to the solution 3
Time: o(n)
Space: o(n)
*/

class Solution {
    public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int max = 0;
		Deque<Integer> stack = new LinkedList<>();
		stack.push(-1);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					int start = stack.peek();
					max = Math.max(i - start, max);
				}
			}
		}

		return max;
    }
}