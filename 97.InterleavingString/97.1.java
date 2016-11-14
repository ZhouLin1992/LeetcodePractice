public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}

		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		
		if (len3 != len1 + len2) {
		    return false;
		}

		// state: dp[len1 + 1][len2 + 1] refers to s1.substring(0, len1) and s2.substring(0, len2)
		// can interleave as s3.substring(0, len1 + len2)
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];

		// initialize
		// null string + null string can combine as null string -> dp[0][0] = true
		dp[0][0] = true;

		// when s1 is no null and s2 is null
		for (int l1 = 1; l1 <= len1; l1++) {
			dp[l1][0] = (s1.charAt(l1 - 1) == s3.charAt(l1 - 1) && dp[l1 - 1][0]);
		}

		// when s1 is null and s2 is not null
		for (int l2 = 1; l2 <= len2; l2++) {
			dp[0][l2] = (s2.charAt(l2 - 1) == s3.charAt(l2 - 1) && dp[0][l2 - 1]);
		}

		// function:
		// 1. If first character of s3 matches with first character of s1, 
		// we move one character ahead in s1;
		// 2. If first character of s3 matches with first character of s2, 
		// we move one character ahead in s2
		for (int l1 = 1; l1<= len1; l1++) {
			for (int l2 = 1; l2 <= len2; l2++) {
				int l = l1 + l2;
				dp[l1][l2] = (dp[l1 - 1][l2] && s1.charAt(l1 - 1) == s3.charAt(l - 1)) ||
							(dp[l1][l2 - 1] && s2.charAt(l2 - 1) == s3.charAt(l - 1));
			}
		}

		// answer
		return dp[len1][len2];       
    }
}