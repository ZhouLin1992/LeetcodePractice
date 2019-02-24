/*
time: o(row * col)
space: o(col)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[] dp = new int[col];
        
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if (r != row - 1 && c != col - 1) {
                    dp[c] = grid[r][c] + Math.min(dp[c + 1], dp[c]);
                // the last row in the grid
                } else if (r == row - 1 && c != col - 1){
                    dp[c] = grid[r][c] + dp[c + 1];
                // the last column in the grid
                } else if (c == col - 1 && r != row - 1) {
                    dp[c] = grid[r][c] + dp[c];
                // the right most cell in the grid
                } else {
                    dp[c] = grid[r][c];
                }
            }
        }
        
        return dp[0];
    }
}