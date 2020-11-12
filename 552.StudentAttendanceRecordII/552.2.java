class Solution {
    private int mod = 1000000007;
    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[][][] dp = new int[n + 1][2][3];
        dp[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        
        for (int i = 1; i <= n; i++) {
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    // 最后一位加入'p', (n - 1)中trailing 'l' 最多可以含2位
                    int val = dp[i - 1][a][2] % mod;
                    // 最后一位加入'a', (n - 1)中trailing 'l' 最多可以含2位
                    if (a > 0) {
                        val = (val + dp[i - 1][a - 1][2]) % mod;
                    }
                    // 最后一位加入'l', (n - 1)中trailing 'l' 最多含(l - 1)位
                    if (l > 0) {
                        val = (val + dp[i - 1][a][l - 1]) % mod;
                    }
                    dp[i][a][l] = val;
                }
            }
        }
        
        return dp[n][1][2];
    }
}