// Binary Search
// Time: O(NlogX), X is the difference between the largest 
// and the smallest
// 我们仍采用猜测法，设L = min(matrix) R= max(matrix) , mid =( L + R ) / 2 ，mid为我们猜测的答案。
// 对于mid，我们不必再所有的行或列种执行二分查找，我们可以从左下角出发，
// 若matrix[i][j] <= mid，则下一次查询在右边（j++），并且该列的所有元素均比mid小，
// 因此可以cnt += (i+1)

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length, col = matrix[0].length;
		int low = matrix[0][0], high = matrix[row - 1][col - 1];
		while (low < high) {
			int mid = low + (high - low) / 2;
			int cnt = getCount(matrix, mid);
			if (cnt < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private int getCount(int[][] matrix, int target) {
		int row = matrix.length - 1, col = 0;
		int cnt = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] <= target) {
				cnt += row + 1;
				col++;
			} else {
				row--;
			}
		}
		return cnt;
	}
}