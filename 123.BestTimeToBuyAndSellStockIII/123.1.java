public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        // left -> right: find the smallest, which is the buy day
        int[] pre = new int[prices.length];
        int minPre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPre = Math.min(minPre, prices[i]);
            pre[i] = Math.max(pre[i - 1], prices[i] - minPre);
        }
        
        // left <- right: find the biggest, which is the sell day
        int[] post = new int[prices.length];
        int maxPost = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxPost = Math.max(maxPost, prices[i]);
            post[i] = Math.max(post[i + 1], maxPost - prices[i]);
        }
        
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(pre[i] + post[i], max);
        }
        
        return max;
    }
}