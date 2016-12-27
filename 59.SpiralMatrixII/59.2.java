public class Solution {
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}

		int[][] matrix = new int[n][n];

		int top = 0;
		int down = n - 1;
		int left = 0;
		int right = n - 1;

		int num = 0;

		while (down >= top && right >= left) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = ++num;
			}

			for (int i = top + 1; i < down; i++) {
				matrix[i][right] = ++num;
			}

			if (top != down) {
				for (int i = right; i >= left; i--) {
					matrix[down][i] = ++num;
				}
			}

			if (left != right) {
				for (int i = down - 1; i > top; i--) {
					matrix[i][left] = ++num;
				}
			}

			top++;
			down--;
			left++;
			right--;
		}

		return matrix;
	}
}