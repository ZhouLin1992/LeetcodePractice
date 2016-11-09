public class Solution {
    public int uniquePaths(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 1 && n == 1) {
			return 1;
		}

		// state
		int[][] func = new int[m][n];

		// initialize
		func[0][0] = 0;
		for (int r = 1; r < m; r++) {
			func[r][0] = 1;
		}
		for (int c = 1; c < n; c++) {
			func[0][c] = 1;
		}

		// function: (x, y) is from either up or left
		for (int row = 1; row < m; row++) {
			for (int col = 1; col < n; col++) {
				func[row][col] = func[row - 1][col] + func[row][col - 1];
			}
		}

		// answer
		return func[m - 1][n - 1];
    }
}