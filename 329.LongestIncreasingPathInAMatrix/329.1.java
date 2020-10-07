class Solution {
    private final int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        int max = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(matrix, i, j, cache));
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix, int r, int c, int[][] cache) {
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        
        int max = 1;
        for (int[] dir : directions) {
            int x = r + dir[0];
            int y = c + dir[1];
            if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0 || matrix[r][c] >= matrix[x][y]) {
                continue;
            }
            max = Math.max(max, dfs(matrix, x, y, cache) + 1);
        }
        
        cache[r][c] = max;
        return max;
    }
}