public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        int res = 0;
        
        // direction array
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                
                res++;
                int r = row;
                int c = col;
                // mark it as visited
                board[row][col] = '.';
                
                for (int i = 0; i < 4; i++) {
                    while (r + dx[i] >= 0 && r + dx[i] < rows && c + dy[i] >= 0 && c + dy[i] < cols && board[r + dx[i]][c + dy[i]] == 'X') {
                        board[r + dx[i]][c + dy[i]] = '.';
                        r += dx[i];
                        c += dy[i];
                    }
                }
            }
        }
        
        return res;
    }
}