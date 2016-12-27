public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        // top-left
        int x1 = 0, y1 = 0;
        int row = matrix.length, col = matrix[0].length;
        
        while (row >= 1 && col >= 1) {
            // down-right
            int x2 = x1 + row - 1, y2 = y1 + col - 1;
            
            // top WHOLE row
            for (int c = y1; c <= y2; c++) {
                res.add(matrix[x1][c]);
            }
            
            // right column
            for (int r = x1 + 1; r < x2; r++) {
                res.add(matrix[r][y2]);
            }
            
            // down WHOLE row
            // need to check if row > 1
            // if row == 1, traverse the same row again
            if (row > 1) {
                for (int c = y2; c >= y1; c--) {
                    res.add(matrix[x2][c]);
                }
            }
            
            // left column
            // need to check if col > 1
            // if col == 1, traverse the same column again
            if (col > 1) {
                for (int r = x2 - 1; r > x1; r--) {
                    res.add(matrix[r][y1]);
                }               
            }

            
            // already traverse 2 rows and 2 columns
            row -= 2;
            col -= 2;
            x1++;
            y1++;
        }
        
        return res;
    }
}