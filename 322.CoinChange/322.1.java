class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int[] dp = new int[amount + 1];
        
        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (coin <= sum && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        
        return dp[amount];
    }
}