public class Solution {
    public int maxProfit(int[] prices) {
    	int buy = Integer.MIN_VALUE, prev_buy;
    	int sell = 0, prev_sell = 0;

    	for (int p: prices) {
    		prev_buy = buy;
    		buy = Math.max(prev_buy, prev_sell - p);
    		prev_sell = sell;
    		sell = Math.max(prev_sell, prev_buy + p);
    	}
    	return sell;
    }
}