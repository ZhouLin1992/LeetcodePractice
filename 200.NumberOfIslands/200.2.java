class Solution {
    public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == '1') {
					count++;
					dfs(row, col, grid);
				}
			}
		}

		return count;
    }

    private void dfs(int row, int col, char[][] grid) {
    	if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
    		return;
    	}

    	if (grid[row][col] == '0') {
    		return;
    	}

    	grid[row][col] = '0';
    	dfs(row + 1, col, grid);
    	dfs(row - 1, col, grid);
    	dfs(row, col + 1, grid);
    	dfs(row, col - 1, grid);
    }
}