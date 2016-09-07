public class Solution {
    public boolean isValidSudoku(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] != '.' && (board[row][col] < '1' || board[row][col] > '9' || !isValidSudoku(row, col, board)))
					return false;
			}
		}
		return true;
	}

	public boolean isValidSudoku(int row, int col, char[][] board) {

		for (int i = 0; i < board.length; i++) {
			if (i != row && board[i][col] != '.' && board[i][col] == board[row][col]) return false;
		}

		for (int j = 0; j < board[row].length; j++) {
			if (j != col && board[row][j] != '.' && board[row][j] == board[row][col]) return false;
		}

		for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
			for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
				if (board[i][j] != '.' && i != row && j != col & board[i][j] == board[row][col]) return false;
			}
		}
		return true;
    }
}