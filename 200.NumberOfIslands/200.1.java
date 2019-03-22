class Solution {
    public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == '1') {
					markBFS(row, col, grid);
					count++;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == '2') {
					grid[row][col] = '1';
				}
			}
		}

		return count;
    }

    private void markBFS(int row, int col, char[][] grid) {
    	Queue<Coordinate> queue = new LinkedList<>();
    	queue.offer(new Coordinate(row, col));
    	grid[row][col] = '2';

    	int rows = grid.length;
    	int cols = grid[0].length;

    	int[] dx = {0, 0, -1, 1};
    	int[] dy = {-1, 1, 0, 0};

    	while (!queue.isEmpty()) {
    		Coordinate curr = queue.poll();

    		for (int i = 0; i < 4; i++) {
    			int x = curr.x + dx[i];
    			int y = curr.y + dy[i];
    			Coordinate newCoor = new Coordinate(x, y);

    			if (isBounded(newCoor, rows, cols) && grid[x][y] == '1') {
    				queue.offer(newCoor);
    				grid[x][y] = '2';
    			}
    		}
    	}
    }

    private boolean isBounded(Coordinate coor, int rows, int cols) {
    	return 0 <= coor.x && coor.x < rows && 0 <= coor.y && coor.y < cols;
    }

    private class Coordinate {
    	int x;
    	int y;
    	public Coordinate(int _x, int _y) {
    		x = _x;
    		y = _y;
    	}
    }
}