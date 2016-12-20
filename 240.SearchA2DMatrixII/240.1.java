// Time complexity: O(M + N), M/N is the row number and column number
// start from the right corner of the matrix, if target is greater than
// the value in the current position, then target can not be in the
// entire row of current position; if the target is less than the value 
// in current position, then target can not be in the entire column in
// the current position

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int row = 0, col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			int compare = matrix[row][col];
			if (compare == target) {
				return true;
			} else if (target > compare) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}
}