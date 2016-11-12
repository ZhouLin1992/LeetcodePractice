public class Solution {
    public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return Integer.MIN_VALUE;
		}

		int len1 = word1.length();
		int len2 = word2.length();

		// state: optimized to O(N) space
		int[] dp = new int[len2 + 1];

		// initialize: dp[l1][l2] -> dp[l2] = l2
		for (int l2 = 0; l2 <= len2; l2++) {
			dp[l2] = l2;
		}

		// function
		for (int l1 = 1; l1 <= len1; l1++) {
			int prev = dp[0];
			dp[0] = l1;
			for (int l2 = 1; l2 <= len2; l2++) {
				int tmp = dp[l2];
				if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
					dp[l2] = prev;
				} else {
					int min = Math.min(prev, dp[l2 - 1]);
					min = Math.min(min, tmp);
					dp[l2] = min + 1;
				}
				prev = tmp;
			}
		}
		
		// answer
		return dp[len2];  
    }
}