/*
DP:
think of an example: ())((())
Time complexity: o(n)
Space complexity: o(n)
*/

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }

        // i_th element of dp represents the length of the longest valid substring ending at i_th index
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;

        for (int i = 1; i < len; i++) {
        	if (s.charAt(i) == ')') {
        		if (s.charAt(i - 1) == '(') {
        			dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;

        		/*
        		"))": 
        		assume there is a valid substring (sub2) ending in the 2nd last ')';
        		if the character right before substring (sub2) is ch == '(', update dp[i] = dp[i - 1] + 2; 
        		also need to consider adding length before the valid substring (right before "ch + sub2")
        		*/
        		// 
        		} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
        			dp[i] = ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
        		}
        	}
        	max = Math.max(max, dp[i]);
        }

        return max;
    }
}