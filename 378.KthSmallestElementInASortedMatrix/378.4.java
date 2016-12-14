// Binary Search
// Time: O(logXNlogN), searching for one row needs O(logN), there
// are N rows, the largest times we need to search is O(logX), X is 
// the difference between the largest and the smallest
// Analysis:
// 1. 将查找上下限设为矩阵的右下角与左上角元素
// 2. 查找过程中对中值在矩阵每一行的位置进行累加，记该值为loc
// 3. 根据loc与k的大小关系调整上下限

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length, col = matrix[0].length;
		int low = matrix[0][0], high = matrix[row - 1][col - 1];
		while (low < high) {
			int mid = low + (high - low) / 2;
			int cnt = 0;
			for (int i = 0; i < row; i++) {
				cnt += (getIndex(matrix[i], mid) + 1);
			}
			if (cnt < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private int getIndex(int[] row, int target) {
		int low = 0, high = row.length - 1;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;
			if (row[mid] <= target) {
				low = mid;
			} else {
				high = mid;
			}
		}

		int res = -1;
		if (row[low] <= target) {
			res = low;
		}

		if (row[high] <= target) {
			res = high;
		}

		return res;
	}
}