/**
Define first cell as most top-left cell, count first cell only.
Count as one battle ship only when left cell and upper cell are not 'X'
*/


class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                
                count++;
            }
        }
        
        return count;
    }
}