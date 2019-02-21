class Solution {
    // use global parameter
    int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        char[][] solution = new char[n][n];
        for (char[] chars : solution) {
            Arrays.fill(chars, '.');
        }
        
        solveNQueens(solution, 0);
        
        return count;
    }

    private void solveNQueens(char[][] solution, int colIndex) {
    	int n = solution.length;
    	if (colIndex == n) {
    		count++;
    		return;
    	}

    	for (int row = 0; row < n; row++) {
    		if (validNQueensSolution(solution, row, colIndex)) {
    			solution[row][colIndex] = 'Q';
    			solveNQueens(solution, colIndex + 1);
    			solution[row][colIndex] = '.';	
    		}
    	}
    }

    private boolean validNQueensSolution(char[][] solution, int row, int col) {
    	// check column by column
    	for (int i = 0; i < solution.length; i++) {
    		for (int j = 0; j < col; j++) {
    			// if there is 'Q' on the two-direction diagonally (relate y = x + b and y = -x + b), or on the same row
    			if (solution[i][j] == 'Q' && (i + col == j + row || i + j == row + col || i == row)) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}