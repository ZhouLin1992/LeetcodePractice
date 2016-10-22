public class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;

		int max = 0;
		int[] cur = new int[matrix[0].length + 1];
		int[] prev = new int[matrix[0].length + 1];

		for (int i = 1; i < matrix.length + 1; i++) {
			for (int j = 1; j < matrix[0].length + 1; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					cur[j] = Math.min(cur[j - 1], Math.min(prev[j - 1], prev[j])) + 1;
					max = Math.max(max, cur[j]);
				} else 
					cur[j] = 0;
			}
			prev = Arrays.copyOf(cur, cur.length);
			cur[0] = 0;
		}
		return max * max;
	}
}