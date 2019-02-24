/*
time: o(row * col)
space: o(row * col)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        // minSums[i][j] represents the minimum sum of the path from the index (i,j) to the bottom rightmost element
        int[][] minSums = new int[row][col];
        
        minSums[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int r = row - 2; r >= 0; r--) {
            minSums[r][col - 1] = minSums[r + 1][col - 1] + grid[r][col - 1];
        }
        for (int c = col - 2; c >= 0; c--) {
            minSums[row - 1][c] = minSums[row - 1][c + 1] + grid[row - 1][c];
        }
        
        for (int r = row - 2; r >= 0; r--) {
            for (int c = col - 2; c >= 0; c--) {
                minSums[r][c] = grid[r][c] + Math.min(minSums[r + 1][c], minSums[r][c + 1]);
            }
        }
        
        return minSums[0][0];
    }
}