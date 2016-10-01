public class Solution {
    public int maxProfit(int[] prices) {
		if (prices.length == 1 || prices.length == 0 || prices == null) return 0;
		int sum = 0;
		for (int p = 1; p < prices.length; p++)
			if (prices[p] > prices[p - 1])
				sum += prices[p] - prices[p - 1];
		return sum;
    }
}