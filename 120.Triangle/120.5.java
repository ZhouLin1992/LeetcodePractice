public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		int size = triangle.size();

		// state
		int[] func = new int[size];

		// initilization
		for (int i = 0; i < size; i++) {
			func[i] = triangle.get(size - 1).get(i);
		}

		// function
		for (int row = size - 2; row >= 0; row--) {
			for (int col = 0; col <= row; col++) {
				func[col] = triangle.get(row).get(col) + Math.min(func[col], func[col + 1]);
			}
		}

		// answer
		return func[0];
	}
}