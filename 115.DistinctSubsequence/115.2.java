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

		// state
		int[] dp = new int[lenT + 1];

		// initialize
		dp[0] = 1;

		// function
		for (int i = 1; i <= lenS; i++) {
			int prev = 1;
			for (int j = 1; j <= lenT; j++) {
				int tmp = dp[j];
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[j] += prev;
				}
				prev = tmp;
			}
		}

		// answer
		return dp[lenT];      
    }
}