public class Solution {
    public boolean isValidSudoku(char[][] board) {
		int[] rows = new int[board.length];
		int[] cols = new int[board.length];
		int[] cube = new int[board.length];
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					int ind = 1 << (board[i][j] - '0');
					if ((ind & rows[i]) != 0 || (ind & cols[j]) != 0 || (ind & cube[(i / 3) * 3 + j / 3]) != 0) 
						return false;
					rows[i] |= ind;
					cols[j] |= ind;
					cube[(i / 3) * 3 + j / 3] |= ind;
				}
			}
		}
		return true;
    }
}