class Solution {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new LinkedList<>();
    	if (n <= 0) {
    		return result;
    	}

        char[][] solution = new char[n][n];
        for (char[] row : solution) {
        	Arrays.fill(row, '.');
        }

        solveNQueens(solution, 0, result);

        return result;
    }

    private void solveNQueens(char[][] solution, int colIndex, List<List<String>> result) {
    	int n = solution.length;
    	if (colIndex == n) {
    		result.add(constructNQueens(solution));
    		return;
    	}

    	for (int row = 0; row < n; row++) {
    		if (validNQueensSolution(solution, row, colIndex)) {
    			solution[row][colIndex] = 'Q';
    			solveNQueens(solution, colIndex + 1, result);
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

    private List<String> constructNQueens(char[][] solution) {
    	List<String> list = new LinkedList<>();
    	for (char[] chars : solution) {
    		list.add(new String(chars));
    	}
    	return list;
    }
}