public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int[][] cache = new int[triangle.size()][triangle.size()];
		for (int i = 0; i < triangle.size(); i++) {
		    for (int j = 0; j < triangle.size(); j++) {
		        cache[i][j] = Integer.MAX_VALUE;
		    }
		}
		return minimumTotal(triangle, cache, 0, 0);
	}

	public int minimumTotal(List<List<Integer>> triangle, int[][] cache, int x, int y) {
		if (x == triangle.size()) {
			return 0;
		}
		
		if (cache[x][y] != Integer.MAX_VALUE) {
		    return cache[x][y];
		}

		cache[x][y] = triangle.get(x).get(y) + Math.min(minimumTotal(triangle, cache, x + 1, y),
														minimumTotal(triangle, cache, x + 1, y + 1));
		return cache[x][y];
	}
}