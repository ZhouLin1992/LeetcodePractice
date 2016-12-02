// time: O(N ^ 2)
// when we find out the peek(right boundary)

public class Solution {
    public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		if (heights.length == 1) {
			return heights[0];
		}

		int area = 0;
		for (int i = 0; i < heights.length; i++) {
			if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
				continue;
			}

			int min = heights[i];
			for (int j = i; j >= 0; j--) {
				min = Math.min(min, heights[j]);
				int tmp = min * (i - j + 1);
				if (area < tmp) {
					area = tmp;
				}
			}
		}

		return area;     
    }
}