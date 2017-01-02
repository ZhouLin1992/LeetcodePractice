public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        boolean[] rows = new boolean[rowLen];
        boolean[] cols = new boolean[colLen];
        
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }
        
        for (int i = 0; i < rowLen; i++) {
            if (rows[i]) {
                for (int c = 0; c < colLen; c++) {
                    matrix[i][c] = 0;
                }
            } 
        }
        
        for (int j = 0; j < colLen; j++) {
            if (cols[j]) {
                for (int r = 0; r < rowLen; r++) {
                    matrix[r][j] = 0;
                }
            }
        }
    }
}