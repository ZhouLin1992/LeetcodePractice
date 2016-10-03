public class Solution {
	public int maxProfit(int[] prices) {
		int b0 = -prices[0], b1 = b0;
		int s0 = 0, s1 = 0;

		for (int p: prices) {
			b0 = Math.max(s2 - p, b1);
			s0 = Math.max(b1 + p, s1);
			b1 = b0; s2 = s1; s1 = s0;
		}
		return s1;
	}
}