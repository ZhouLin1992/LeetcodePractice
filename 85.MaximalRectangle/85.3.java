class Solution {
    public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] height = new int[cols + 1];
		int area = 0;

		for (int r = 0; r < rows; r++) {
			Deque<Integer> stack = new LinkedList<>();
			stack.push(-1);
			for (int i = 0; i <= cols; i++) {
				if (i < cols && matrix[r][i] == '1') {
					height[i] += 1;
				} else {
					height[i] = 0;
				}

				while (stack.peek() != -1 && height[i] < height[stack.peek()]) {
					area = Math.max(area, height[stack.pop()] * (i - stack.peek() - 1));
				}
				stack.push(i);
			}
		}

		return area;
    }
}