/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment

dp[i][j] represents max profit up until prices[j] using at most i transactions
dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
         = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
dp[0, j] = 0; 0 transactions makes 0 profit
dp[i, 0] = 0; if there is only one price data point you can't make any transaction.

For example, if j == 8, then amongst all jj == 1,2,...,7
The max profit could be one of the following:
dp[i-1][0] + prices[8] - prices[0]
dp[i-1][1] + prices[8] - prices[1]
dp[i-1][2] + prices[8] - prices[2]
...
dp[i-1][6] + prices[8] - prices[6]
dp[i-1][7] + prices[8] - prices[7]

localMax is the max value amongst all:
dp[i-1][0] - prices[0]
dp[i-1][1] - prices[1]
dp[i-1][2] - prices[2]
...
dp[i-1][6] - prices[6]
dp[i-1][7] - prices[7]

Then localMax + prices[8] is the max profit if we sell the stock at day 8. 
Then we compare this result with the max profit of not selling the stock at day 8, take the max of the two.
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int result = 0;
        if (k >= len / 2) {
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            
            return result;
        }
        
        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][len - 1];
    }
}