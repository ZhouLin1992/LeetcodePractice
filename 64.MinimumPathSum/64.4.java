/*
time: o(row * col)
space: o(1)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                if (r == row - 1 && c != col - 1) {
                    grid[r][c] += grid[r][c + 1];
                } else if (c == col - 1 && r != row - 1) {
                    grid[r][c] += grid[r + 1][c];
                } else if (r != row - 1 && c != col - 1){
                    grid[r][c] += Math.min(grid[r + 1][c], grid[r][c + 1]);
                }
            }
        }
        
        return grid[0][0];
    }
}