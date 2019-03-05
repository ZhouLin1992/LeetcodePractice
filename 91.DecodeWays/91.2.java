class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
        	int current = Integer.valueOf(s.substring(i, i + 1));
        	// consider prev+current together as a two-digit number
        	int prev = Integer.valueOf(s.substring(i - 1, i + 1));
        	if (1 <= current && current <= 9) {
        		dp[i] += dp[i - 1];
        	}
        	if (10 <= prev && prev <= 26) {
        		dp[i] += i >= 2 ? dp[i - 2] : 1;
        	}
        }

        return dp[s.length() - 1];
    }
}