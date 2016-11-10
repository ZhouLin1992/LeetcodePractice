public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
		// state
		boolean[] dp = new boolean[s.length() + 1];

		// initialize
		int maxLen = getMaxLength(wordDict);
		dp[0] = true;

		// function
		for (int i = 1; i <= s.length(); i++) {
			for (int lastWordLength = 1; lastWordLength <= i && lastWordLength <= maxLen; lastWordLength++) {
				if (dp[i - lastWordLength] && wordDict.contains(s.substring(i - lastWordLength, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		// answer
        return dp[s.length()];
	}

	private int getMaxLength(Set<String> wordDict) {
		int max = 0;
		for (String str: wordDict) {
			if (str.length() > max) {
				max = str.length();
			}
		}
		return max;
    }
}