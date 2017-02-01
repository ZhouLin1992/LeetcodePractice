public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                // if left neighbour or up neighbour is 'X', means that current block
                // is part of the the left battleship or up battleship
                if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    res++;
                }
            }
        }
        
        return res;
    }
}