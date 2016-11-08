// DFS traversal; O(N) = 2 ^ N; the input is too large that DFS is too deep
public class Solution {
	private int minSum = Integer.MAX_VALUE;
	public int minimumTotal(List<List<Integer>> triangle) {
		int sum = 0;
		if (triangle.isEmpty()) {
			return sum;
		}
		traverse(0, 0, sum, triangle);
		return sum;
	}

	public void traverse(int x, int y, int sum, List<List<Integer>> triangle) {
		if (x == triangle.size()) {
			if (sum < minSum) {
				minSum = sum;
			}
		}

		sum = sum + triangle.get(x).get(y);
		traverse(x + 1, y, sum, triangle);
		traverse(x + 1, y + 1, sum, triangle);
	}
}