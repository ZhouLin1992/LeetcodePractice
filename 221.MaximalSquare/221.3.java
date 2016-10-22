public class Solution {
    public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;

		int max = 0, topleft = 0;
		int[] dp = new int[matrix[0].length + 1];

		for (int i = 1; i < matrix.length + 1; i++) {
			for (int j = 1; j < matrix[0].length + 1; j++) {
				int tmp = dp[j];
				if (matrix[i - 1][j - 1] == '0')
					dp[j] = 0;
				else {
					dp[j] = Math.min(dp[j - 1], Math.min(dp[j], topleft)) + 1;
					max = Math.max(dp[j], max);
				}
				topleft = tmp;
			}
		}
		return max * max;
    }
}