// [second state, first state]
// [next <- current]
// [0, 0]: dead <- dead
// [0, 1]: dead <- live, <2 live neighbours or >3 live neighbours
// [1, 0]: live <- dead, ==3 live neighbours
// [1, 1]: live <- live, 2/3 live neighbours

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = liveNeighbours(board, i, j, rows, cols);
                
                // since the default of second state is 0,
                // there is no need to consider [0 <- 0] / [0 <- 1]
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    // [0, 1] -> [1, 1]
                    board[i][j] = 3;
                }
                
                if (board[i][j] == 0 && lives == 3) {
                    // [0, 0] -> [1, 0]
                    board[i][j] = 2;
                }
            }
        }
        
        // convert it to second state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int liveNeighbours(int[][] board, int i, int j, int rows, int cols) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, rows - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, cols - 1); y++) {
                // only take first state into consideration
                lives += board[x][y] & 1;
            }
        }
        
        // minus the first state of board[i][j]
        lives -= board[i][j] & 1;
        return lives;
    }
}