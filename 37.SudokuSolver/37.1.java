public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    continue;
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(ch, board, row, col)) {
                        board[row][col] = ch;
                        if (solve(board)) {
                            return true;
                        }
                        // backtracking
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char ch, char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == ch) {
                return false;
            }
        }
        
        for (int j = 0; j < board[0].length; j++) {
            if (j != col && board[row][j] == ch) {
                return false;
            }
        }
        
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (i != row && j != col && board[i][j] == ch) {
                    return false;
                }
            }
        }
        
        return true;
    }
}