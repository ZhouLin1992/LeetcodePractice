/*
time: o(n ^ 2)
space: o(n)
*/

class Solution {
    public boolean isMatch(String s, String p) {
		int lenS = s.length();
        int lenP = p.length();
		boolean[][] dp = new boolean[2][lenP + 1];

		dp[0][0] = true;
		for (int j = 1; j <= lenP; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i <= lenS; i++) {
			// Note: need to intialize the cell with index j == 0 as false
            dp[i % 2][0] = false;
			for (int j = 1; j <= lenP; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					dp[i % 2][j] = dp[(i - 1) % 2][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i % 2][j] = dp[(i - 1) % 2][j] || dp[i % 2][j - 1];
				} else {
					// Note: do not forget to put cell without any matching of above 2 conditions as false
                    dp[i % 2][j] = false;
                }
			}
		}

		return dp[lenS % 2][lenP];
    }
}