// time complexity: O(N ^ 2)
// 1. every row is a base. From every row to upper 
// direction, we can consider it as histogram
// e.g. 		 histogram
// 0 0 1 0 		  0 0 1 0 
// 0 0 0 1   ->   0 0 0 1
// 0 1 1 1		  0 1 1 2
// 0 0 1 1 		  0 0 2 3

// 2. for histogram of every row, in order to get the
// maximum area in the histogram, we can use the method
// of largest rectangle in histogram 


public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null) {
			return 0;
		}

		int row = matrix.length;
		if (row == 0) {
			return 0;
		}

		int col = matrix[0].length;
		if (col == 0) {
			return 0;
		}

		// state
		int[][] histogram = new int[row][col];

		// initialize: the first row
		for (int i = 0; i < col; i++) {
			histogram[0][i] = Character.getNumericValue(matrix[0][i]);
		}

		// function
		for (int r = 1; r < row; r++) {
			for (int c = 0; c < col; c++) {
				histogram[r][c] = matrix[r][c] == '1' ? histogram[r - 1][c] + 1 : 0;
			}
		}

		// maximum area
		int maxArea = 0;
		for (int r = 0; r < row; r++) {
			Stack<Integer> stack = new Stack<>();
			for (int c = 0; c <= col; c++) {
				// for the calculation of the last bar in the histogram
				int curt = c == col ? -1 : histogram[r][c];
				// when there are elements in the stack and the peek element
				// is larger than the current element
				while (!stack.isEmpty() && histogram[r][stack.peek()] > curt) {
					int height = histogram[r][stack.pop()];
					// if the stack is empty, this means that the current element(height)
					// is the smallest element in the stack, its left bound can be extended
					// to index(-1)
					int width = stack.isEmpty() ? c : c - stack.peek() - 1;
					int area = height * width;
					maxArea = Math.max(maxArea, area);
				}
				// when at the beginning, the stack is empty
				stack.push(c);
			}
		}
		return maxArea;
	}
}