public class Solution {
    public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1 || prices == null || prices.length == 2 && prices[1] < prices[0]) return 0;
		if (prices.length == 2 && prices[1] > prices[0]) return prices[1] - prices[0];

		int p1 = 0, p2 = 1;
		int diff = 0, tmp = 0;

		while (p1 < p2 && p2 < prices.length) {
			if (prices[p2] < prices[p1])
				p1 = p2;
			else if (prices[p2] > prices[p1])
				tmp = prices[p2] - prices[p1];
			if (tmp > diff)
				diff = tmp;
			p2++;
		}
		return diff;
    }
}