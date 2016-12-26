public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        
        // transpose, flip symmetrically, diagonal line as the pivot
        // 原矩阵 -> 转置矩阵
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
        
        // flip it horizontally symmetrical
        // 转置矩阵 -> reverse每行元素
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = matrix[row][i];
                matrix[row][i] = matrix[row][n - 1 - i];
                matrix[row][n - 1 - i] = tmp;
            }
        }
    }
}