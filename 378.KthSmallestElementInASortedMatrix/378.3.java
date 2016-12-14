// binary search
// Time: O(N^2logX), X is the difference between the largest number
// and the smallest number

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length, col = matrix[0].length;
		int low = matrix[0][0], high = matrix[row - 1][col - 1];
		while (low < high) {
			int mid = low + (high - low) / 2;
			int cnt = 0, j = col - 1;
			for (int i = 0; i < row; i++) {
				while (j >= 0 && matrix[i][j] > mid) {
				    j--;
				}
				cnt += (j + 1);
			}
			if (cnt < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}