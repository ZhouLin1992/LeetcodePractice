/*
time: o(n ^ 2)
space: o(n ^ 2)
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        
        dp[0][0] = true;
        for (int j = 1; j <= lenP; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // consider s.charAt(i - 1) as part of '*' or '*' refers to zero occurence
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[lenS][lenP];
    }
}