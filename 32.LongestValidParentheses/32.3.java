/*
left and right pointer:
Time: o(n)
Space: o(1)
*/

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		left++;
        	} else {
        		right++;
        	}
        	if (left == right) {
        		max = Math.max(max, 2 * left);
        	} else if (left < right) {
        		left = 0;
        		right = 0;
        	}
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	if (s.charAt(i) == ')') {
        		right++;
        	} else {
        		left++;
        	}
        	if (left == right) {
        		max = Math.max(max, 2 * right);
        	} else if (left > right) {
        		left = 0;
        		right = 0;
        	}
        }

        return max;
    }
}