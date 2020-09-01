class NumMatrix {
    private int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;            
        }
        
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        dp = new int[rowsCount + 1][colsCount + 1];
        
        for (int i = 1; i <= rowsCount; i++) {
            for (int j = 1; j <= colsCount; j++) {
                // 该点到(0, 0)组成的矩形，所有值的和
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */