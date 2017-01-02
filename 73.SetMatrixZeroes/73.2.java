// 题目要求O(1)的空间消耗。
// 1. 我们可以使用第一行，第一列来作为Flag，记录某一行，某一列是否应该被设置为0.
// 2. 因为第一行，第一列共用左上角的flag，所以我们需要另外找2个flag来定义第一行，第一列本身是否应该设置为0: row1Zero， col1Zero
// 3. 先扫描首行，首列把首行首列的flag算出。
// 4. 扫描其他的矩阵，将第一行每一列的flag算出。
// 5. 设置矩阵中除了首行首列的cells.
// 6. 设置首行，设置首列。


public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        boolean row0 = false, col0 = false;
        int rowLen = matrix.length, colLen = matrix[0].length;
        
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (matrix[r][c] != 0) {
                    continue;
                }
                
                matrix[r][0] = 0;
                matrix[0][c] = 0;
                
                if (r == 0) {
                    row0 = true;
                }
                
                if (c == 0) {
                    col0 = true;
                }
            }
        }
        
        for (int r = 1; r < rowLen; r++) {
            for (int c = 1; c < colLen; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                } 
            }
        }
        
        if (row0) {
            for (int c = 0; c < colLen; c++) {
                matrix[0][c] = 0;
            }
        }
        
        if (col0) {
            for (int r = 0; r < rowLen; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}