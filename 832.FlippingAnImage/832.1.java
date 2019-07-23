class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        
        int rows = A.length;
        int cols = A[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c <= (cols - 1) / 2; c++) {
                if ((A[r][c] ^ A[r][cols - 1 - c]) == 0) {
                    if (A[r][c] == 0) {
                        A[r][c] = 1;
                        A[r][cols - 1 - c] = 1;
                    } else {
                        A[r][c] = 0;
                        A[r][cols - 1 - c] = 0;
                    }
                }
            }
        }
        
        return A;
    }
}