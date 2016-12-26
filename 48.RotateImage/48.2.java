public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int len = matrix.length;
		int top = 0, down = len - 1, left = 0, right = len - 1;
		int n = len;
        
        // 外圈 -> 内圈
		while (n > 1) {
			for (int i = 0; i < n - 1; i++) {
				int tmp = matrix[top][left + i];
				// 上面 = 左边
				matrix[top][left + i] = matrix[down - i][left];
				// 左边 = 下面
				matrix[down - i][left] = matrix[down][right - i];
				// 下面 = 右边
				matrix[down][right - i] = matrix[top + i][right];
				// 右边 = 上面
				matrix[top + i][right] = tmp;
			}
			top++;
			down--;
			left++;
			right--;
			n -= 2;			
		}
	}
}