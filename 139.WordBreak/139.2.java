public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict) {
		// state: for index i, means that substring(0, i) can be wordBreak;
		boolean[] dp = new boolean[s.length() + 1];

		// initialize
		dp[0] = true;

		// function
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
				if (dp[i]) {
					break;
				}
			}
		}

		// answer
		return dp[s.length()];
	}
}