class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;
        int oneBuyoneSell = 0;
        int twoBuytwoSell = 0;
        
        for (int i = 0; i < prices.length; i++) {
            oneBuy = Math.min(oneBuy, prices[i]);
            oneBuyoneSell = Math.max(oneBuyoneSell, prices[i] - oneBuy);
            // Suppose in real life, you have bought and sold a stock and made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars, how would you think this? You must think, um, I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
            twoBuy = Math.min(twoBuy, prices[i] - oneBuyoneSell);
            twoBuytwoSell = Math.max(twoBuytwoSell, prices[i] - twoBuy);
        }
        
        return twoBuytwoSell;
    }
}