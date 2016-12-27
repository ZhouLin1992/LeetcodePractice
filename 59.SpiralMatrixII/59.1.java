public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        
        int[][] matrix = new int[n][n];
        
        // directions: 0 right, 1 down, 2 left, 3 up
        int direct = 0;
        
        // 1: visiting rows by right direction
        // -1: visiting rows by left direction
        int[] x = {1, 0, -1, 0};
        
        // 1: visiting columns by down direction
        // -1: visiting columns by up direction
        int[] y = {0, 1, 0, -1};
        
        int startx = 0;
        int starty = 0;
        
        int visitedRows = 0;
        int visitedCols = 0;
        
        int candidateNum = 0;
        int element = 0;
        int step = 0;
        
        while(true) {
            // means that we are dealing with columns
            // but we care about number of rows
            if (x[direct] == 0) {
                candidateNum = n - visitedRows;
            } else {
                candidateNum = n - visitedCols;
            }
            
            if (candidateNum <= 0) {
                break;
            }
            
            matrix[startx][starty] = ++element;
            step++;
            
            if (step == candidateNum) {
                step = 0;
                visitedRows += x[direct] == 0 ? 0 : 1;
                visitedCols += y[direct] == 0 ? 0 : 1;
                direct++;
                direct %= 4;
            }
            
            startx += y[direct];
            starty += x[direct];
        }
        
        return matrix;
    }
}