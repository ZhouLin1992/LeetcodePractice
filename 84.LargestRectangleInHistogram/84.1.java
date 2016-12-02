// time: O(N ^ 2)
// TLE, because there are too many same calculations happening

public class Solution {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		if (heights.length == 1) {
			return heights[0];
		}

		int area = Integer.MIN_VALUE;

		for (int i = 0; i < heights.length; i++) {
			int min = heights[i];
			for (int j = i; j >= 0; j--) {
				min = Math.min(min, heights[j]);
				int tmp = min * (i - j + 1);
				if (tmp > area) {
					area = tmp;
				}
			}
		}

		return area;
	}
}