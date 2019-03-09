class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null || s2 == null || s3 == null) {
    		return false;
    	}

    	int len1 = s1.length();
    	int len2 = s2.length();
    	int len3 = s3.length();

    	if (len1 + len2 != len3) {
    		return false;
    	}

    	boolean[][] dp = new boolean[len1 + 1][len2 + 1];

    	for (int l1 = 0; l1 <= len1; l1++) {
    		for (int l2 = 0; l2 <= len2; l2++) {
    			if (l1 == 0 && l2 == 0) {
    				dp[0][0] = true;
    			} else if (l2 == 0) {
    				dp[l1][l2] = (s1.charAt(l1 - 1) == s3.charAt(l1 - 1) && dp[l1 - 1][0]);
    			} else if (l1 == 0) {
    				dp[l1][l2] = (s2.charAt(l2 - 1) == s3.charAt(l2 - 1) && dp[0][l2 - 1]);
    			} else {
    				dp[l1][l2] = (s2.charAt(l2 - 1) == s3.charAt(l1 + l2 - 1) && dp[l1][l2 - 1]) 
    				|| (s1.charAt(l1 - 1) == s3.charAt(l1 + l2 - 1) && dp[l1 - 1][l2]);
    			}
    		}
    	}

    	return dp[len1][len2];
    }
}