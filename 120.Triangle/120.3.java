// Bottom-Up

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int size = triangle.size();

		// State: from (x, y) to bottom
		int[][] func = new int[size][size];

		// Initialization
		for (int i = 0; i < size; i++) {
			func[size - 1][i] = triangle.get(size - 1).get(i);
		}

		// Function
		for (int row = size - 2; row >= 0; row--) {
			int listSize = triangle.get(row).size();
			for (int col = 0; col < listSize; col++) {
				func[row][col] = triangle.get(row).get(col) + Math.min(func[row + 1][col], 
																func[row + 1][col + 1]);
			}
		}
		// Answer
		return func[0][0];
	}
}