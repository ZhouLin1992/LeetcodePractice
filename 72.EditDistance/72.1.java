public class Solution {
    public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return Integer.MIN_VALUE;
		} 

		int len1 = word1.length();
		int len2 = word2.length();

		// state: dp[m][n] refers to min steps to convert word1.substring(0, m) to
		// word2.substring(0, n)
		int[][] dp = new int[len1 + 1][len2 + 1];

		// initialize: dp[m][0] refers to convert word1.substring(0, m) to a null string, m deletion
		// dp[0][n] refers to convert a null string to word2.substring(0, n), n insertion
		for (int m = 0; m <= len1; m++) {
			dp[m][0] = m;
		}

		for (int n = 0; n <= len2; n++) {
			dp[0][n] = n;
		}

		// function
		for (int m = 1; m <= len1; m++) {
			for (int n = 1; n <= len2; n++) {
				if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
					dp[m][n] = dp[m - 1][n - 1];
				} else {
					// min value for [(replace & insertion & deletion) + 1]
					int min = Math.min(dp[m - 1][n - 1], dp[m][n - 1]);
					min = Math.min(min, dp[m - 1][n]); 
					dp[m][n] = min + 1;
				}
			}
		}

		// answer
		return dp[len1][len2];        
    }
}