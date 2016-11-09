public class Solution {
    public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return Integer.MIN_VALUE;
		}

		int row = grid.length;
		int column = grid[0].length;

		// state
		int[][] func = new int[row][column];
        
        func[0][0] = grid[0][0];
		// initialize: the first row and the first column
		for (int r = 1; r < row; r++) {
			func[r][0] = grid[r][0] + func[r - 1][0];
		}
		for (int c = 1; c < column; c++) {
			func[0][c] = grid[0][c] + func[0][c - 1];
		}

		// function: (x, y) can either from up(x - 1, y) or left(x, y - 1)
		for (int r = 1; r < row; r++) {
			for (int c = 1; c < column; c++) {
				func[r][c] = grid[r][c] + Math.min(func[r - 1][c], func[r][c - 1]);
			}
		}
		return func[row - 1][column - 1];
    }
}