class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c <= (A[0].length - 1) / 2; c++) {
                if (A[r][c] == A[r][A[0].length - 1 - c]) {
                    A[r][c] = A[r][A[0].length - 1 - c] ^= 1;
                }
            }
        }
        
        return A;
    }
}