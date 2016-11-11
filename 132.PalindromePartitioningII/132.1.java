public class Solution {
    public int minCut(String s) {
		if (s == null) {
			return 0;
		}

		if (s.length() <= 1) {
			return 0;
		}

		int len = s.length();

		// state: 
		// 1. mark[i][j] define if substring(j, i) is palindrome
		// 2. record the minimum cut for substring(0, i)
		boolean[][] mark = new boolean[len][len];
		int[] cut = new int[len + 1];

		// initialize
		cut[0] = 0;

		// function
		for (int i = 1; i <= s.length(); i++) {
			int min = i;
			for (int j = 0; j < i; j++) {
				if (s.charAt(j) == s.charAt(i - 1) && ((i - 1 - j <= 2) || mark[j + 1][i - 1 - 1])) {
					mark[j][i - 1] = true;
					min = Math.min(cut[j] + 1, min);				
				}
			}
			cut[i] = min;
		}

		// answer
		return cut[s.length()] - 1;        
    }
}