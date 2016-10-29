public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		if (matrix[0] == null || matrix[0].length == 0)
			return false;

		int row = matrix.length, col = matrix[0].length;
		int lo = 0, hi = row * col - 1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			int m = mid / col, n = mid % col;
			if (matrix[m][n] == target)
				return true;
			else if (matrix[m][n] < target)
				lo = mid;
			else 
				hi = mid;
		}

		if (matrix[lo / col][lo % col] == target || matrix[hi / col][hi % col] == target)
			return true;

		return false;
    }
}