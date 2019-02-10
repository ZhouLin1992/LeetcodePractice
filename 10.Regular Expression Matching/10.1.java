refer to: https://www.youtube.com/watch?v=l3hda49XcDE&index=17&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        
        memo[0][0] = true;
        
        // initiate memo if pattern is: a*, a*b*, a*b*c*, etc.
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                memo[0][j] = memo[0][j - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // assume zero occurence of character before '*'
                    memo[i][j] = memo[i][j - 2];
                    // consider s.charAt(i - 1) as part of _* in the pattern p
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        memo[i][j] = memo[i][j] || memo[i - 1][j];
                    }
                } else {
                    memo[i][j] = false;
                }
            }
        }
        
        return memo[s.length()][p.length()];
    }
}