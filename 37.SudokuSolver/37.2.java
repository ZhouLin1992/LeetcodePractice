class Solution {
    public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		solve(board);
    }

    private boolean solve(char[][] board) {
    	for (int row = 0; row < board.length; row++) {
    		for (int col = 0; col < board[row].length; col++) {
    			if (board[row][col] != '.') {
    				continue;
    			}
    			for (char ch = '1'; ch <= '9'; ch++) {
    				if (isValid(board, ch, row, col)) {
    					board[row][col] = ch;
    					if (solve(board)) {
    						return true;
    					}
    					board[row][col] = '.';
    				}
    			}
    			return false;
    		}
    	}
    	return true;
    }

    private boolean isValid(char[][] board, char ch, int row, int col) {
    	for (int i = 0; i < board.length; i++) {
    		if (board[i][col] == ch) {
    			return false;
    		}
    		if (board[row][i] == ch) {
    			return false;
    		}
    		if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
    			return false;
    		}
    	}
        
        return true;
    }
}