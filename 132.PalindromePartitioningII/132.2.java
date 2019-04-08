class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] mark = new boolean[len][len];
        int[] dp = new int[len];
        
        for (int end = 0; end < len; end++) {
            // initialize: partition into every single character
            dp[end] = end;
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || mark[start + 1][end - 1])) {
                    mark[start][end] = true;
                    /*
                    if start == 0, the whole substring(start, end + 1) is palindrome, no partition needed;
                    dp[start - 1] + 1: partition into two parts: substring(0, start) & substring(start, end + 1)
                    */
                    dp[end] = start == 0 ? 0 : Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }
        
        return dp[len - 1];
    }
}