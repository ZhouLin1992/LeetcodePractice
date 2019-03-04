/*
height[i]: record the current number of countinous '1' in column i;
left[i]: record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[i];
right[i]: record the right most index j which satifies that for any index k from i to  j, height[k] >= height[i];
by understanding the definition, we can easily figure out we need to update maxArea with value (height[i] * (right[i] - left[i] + 1));

refer to https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] height = new int[cols];
		int[] left = new int[cols];
		int[] right = new int[cols];
		Arrays.fill(right, cols - 1);

		int area = 0;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == '1') {
					height[c] += 1;
				} else {
					height[c] = 0;
				}
			}

			int leftBound = 0;
			for (int c = 0; c < cols; c++) {
				if (matrix[r][c] == '1') {
					left[c] = Math.max(left[c], leftBound);
				} else {
					left[c] = 0;
					leftBound = c + 1;
				}
			}

			int rightBound = cols - 1;
			for (int c = cols - 1; c >= 0; c--) {
				if (matrix[r][c] == '1') {
					right[c] = Math.min(right[c], rightBound);
				} else {
					right[c] = cols - 1;
					rightBound = c - 1;
				}
			}

			for (int c = 0; c < cols; c++) {
				area = Math.max(area, height[c] * (right[c] - left[c] + 1));
			}
		}

		return area;
    }
}