/**
http://zxi.mytechroad.com/blog/searching/leetcode-51-n-queens/
总结一些规律 与代码无关：
假设长宽为n，总共有
右向下对角线(\): 2*n - 1, index: x + y
左向下对角线(/): 2*n - 1, index: x - y + n - 1
**/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        if (n <= 0) {
            return result;
        }
        
        char[][] solution = new char[n][n];
        for (char[] chs : solution) {
            Arrays.fill(chs, '.');
        }
        
        solver(0, solution, result);
        
        return result;
    }
    
    private void solver(int row, char[][] solution, List<List<String>> result) {
        int n = solution.length;
        if (row == n) {
            result.add(constructor(solution));
            return;
        }
        
        for (int c = 0; c < n; c++) {
            if (isValid(solution, row, c)) {
                solution[row][c] = 'Q';
                solver(row + 1, solution, result);
                solution[row][c] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] solution, int rowIdx, int col) {
        for (int r = 0; r < rowIdx; r++) {
            for (int c = 0; c < solution.length; c++) {
                if (solution[r][c] == 'Q' && (c == col || rowIdx + col == r + c || rowIdx - col == r - c)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private List<String> constructor(char[][] solution) {
        List<String> list = new LinkedList<>();
        for (char[] row : solution) {
            list.add(new String(row));
        }
        return list;
    }
}