// 本题查看有没有可能达到棋盘的当前状态
class Solution {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        int turns = 0;
        int diag = 0;
        int antidiag = 0;
        int[] rows = new int[3];
        int[] cols = new int[3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r].charAt(c) == 'X') {
                    turns++;
                    if (r == c) {
                        diag++;                        
                    }
                    if (r + c == 2) {
                        antidiag++;    
                    }
                    rows[r]++;
                    cols[c]++;
                } else if (board[r].charAt(c) == 'O') {
                    turns--;
                    if (r == c) {
                        diag--;
                    }
                    if (r + c == 2) {
                        antidiag--;    
                    }
                    rows[r]--;
                    cols[c]--;
                }
            }
        }
        
        boolean xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                       cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                       diag == 3 || antidiag == 3;
        
        boolean owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                       cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                       diag == -3 || antidiag == -3;
        
        // when X wins, O cannot move; when O wins, X cannot move
        if (xwin && turns == 0 || owin && turns == 1) {
            return false;
        }
        
        // 如果turns > 1不可以达到；如果turns当前棋子是X或O，能达到的状态是一边赢或者两边都输
        return ((turns == 0 || turns == 1) && (!xwin || !owin));
    }
}