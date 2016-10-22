public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

		int[][] count = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			count[i][0] = matrix[i][0] - '0';
			max = Math.max(max, count[i][0]);
		}

		for (int j = 0; j < matrix[0].length; j++) {
			count[0][j] = matrix[0][j] - '0';
			max = Math.max(max, count[0][j]);			
		}

		for (int i = 1; i < matrix.length; i++) 
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					count[i][j] = Math.min(count[i - 1][j - 1], Math.min(count[i][j - 1], count[i - 1][j])) + 1;
					max = Math.max(max, count[i][j]);
				}
			}

		return max * max;
    }
}