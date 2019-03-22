class Solution {
    public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int rows = board.length;
		int cols = board[0].length;

		for (int r = 0; r < rows; r++) {
			bfs(r, 0, board);
			bfs(r, cols - 1, board);
		}

		for (int c = 0; c < cols; c++) {
			bfs(0, c, board);
			bfs(rows - 1, c, board);
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c] == 'O') {
					board[r][c] = 'X';
				}
				if (board[r][c] == '#') {
					board[r][c] = 'O';
				}
			}
		}
    }

    private void bfs(int r, int c, char[][] board) {
    	Queue<Coordinate> queue = new LinkedList<>();
    	queue.add(new Coordinate(r, c));
    	int[] dx = {0, 0, -1, 1};
    	int[] dy = {-1, 1, 0, 0};

    	while (!queue.isEmpty()) {
    		Coordinate curr = queue.poll();
    		int x = curr.x;
    		int y = curr.y;

    		if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
    			continue;
    		}

    		if (board[x][y] != 'O') {
    			continue;
    		}

    		board[x][y] = '#';
    		for (int i = 0; i < 4; i++) {
    			queue.offer(new Coordinate(x + dx[i], y + dy[i]));
    		}
    	}
    }
}

class Coordinate {
    int x;
    int y;
    public Coordinate(int _x, int _y) {
        x = _x;
        y = _y;
    }
}