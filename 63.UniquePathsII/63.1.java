public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;

		// state
		int[][] func = new int[row][column];

		// initialize
		// first column
		for (int r = 0; r < row; r++) {
			if (obstacleGrid[r][0] == 0) {
				func[r][0] = 1;
			} else {
			    break;
			}
		}
		// first row
		for (int c = 0; c < column; c++) {
			if (obstacleGrid[0][c] == 0) {
				func[0][c] = 1;
			} else {
				break;
			}
		}

		// function
		for (int r = 1; r < row; r++) {
			for (int c = 1; c < column; c++) {
				if (obstacleGrid[r][c] == 0) {
					// from either up or left
					func[r][c] = func[r - 1][c] + func[r][c - 1];
				} else {
					func[r][c] = 0;
				}
			}
		}

		// answer
		return func[row - 1][column - 1];        
    }
}