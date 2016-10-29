public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int row = matrix.length, col = matrix[0].length;
		int lo = 0, hi = row - 1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			int midNum = matrix[mid][0];
			
			if (midNum == target)
				return true;
			else if (midNum < target)
				lo = mid;
			else 
				hi = mid;
		}

		int rowLoc = 0;
		if (matrix[lo][0] > target || matrix[hi][col - 1] < target)
			return false;

		if (matrix[lo][0] == target || matrix[lo][col - 1] == target || 
			matrix[hi][0] == target || matrix[hi][col - 1] == target)
			return true;

		if (matrix[hi][0] > target)
			rowLoc = lo;
		else
			rowLoc = hi;

		lo = 0; hi = col - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			int midNum = matrix[rowLoc][mid];

			if (midNum == target) 
				return true;
			else if (midNum < target)
				lo = mid;
			else 
				hi = mid;
		}

		if (matrix[rowLoc][lo] == target || matrix[rowLoc][hi] == target)
			return true;

		return false;
    }
}