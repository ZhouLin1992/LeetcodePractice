public class Solution {
    public int numDistinct(String s, String t) {
		if (s == null || t == null) {
			return 0;
		}

		if (s.length() < t.length()) {
			return 0;
		}

		int lenS = s.length();
		int lenT = t.length();

		// state dp[s][t] refers to how many ways we can get from s.substring(0, s)
		// to form t.substring(0, t)
		int[][] dp = new int[lenS + 1][lenT + 1];

		// initialize: 
		// 1. dp[lenS][0] refers to how many ways we can get from s.substring(0, lenS)
		// to from a null string, there is only one way;
		// 2. dp[0][lenT] refers to how many ways we can get from a null string to form
		// a t.substring(0, lenT), there is no way.
		for (int strS = 0; strS <= lenS; strS++) {
			dp[strS][0] = 1;
		}

		// function: 
		// 1. if (s.charAt(strS - 1) == t.charAt(strT - 1)), use 
		// the equation: C(m, n) = C(m - 1, n - 1) + C(m - 1, n);
		// 2. if (s.charAt(strS - 1) != t.charAt(strT - 1)), 
		// dp[strS][strT] = dp[strS - 1][strT].
		for (int strS = 1; strS <= lenS; strS++) {
			for (int strT = 1; strT <= lenT; strT++) {
				if (s.charAt(strS - 1) == t.charAt(strT - 1)) {
					dp[strS][strT] = dp[strS - 1][strT - 1] + dp[strS - 1][strT];
				} else {
					dp[strS][strT] = dp[strS - 1][strT];
				}
			}
		}

		// answer
		return dp[lenS][lenT];        
    }
}