public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return true;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        int len = word.length();
        if (index == len) {
            return true;
        }
        
        // check if the i, j are out of bound
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        
        // the character doesn't match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // mark the block has been visited
        board[i][j] = '#';
        
        boolean hasWord = dfs(board, word, index + 1, i + 1, j) || dfs(board, word, index + 1, i - 1, j) || dfs(board, word, index + 1, i, j + 1) || dfs(board, word, index + 1, i, j - 1);
        
        // backtracking
        board[i][j] = word.charAt(index);
        return hasWord;
    }
}