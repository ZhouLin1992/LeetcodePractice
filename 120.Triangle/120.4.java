// Top-Down

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		
		int size = triangle.size();
		
		// state
		int[][] func = new int[size][size];
        
		// initialization (corner case): the first and the last number of each row

		func[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < size; i++) {
			func[i][0] = func[i - 1][0] + triangle.get(i).get(0);
			func[i][i] = func[i - 1][i - 1] + triangle.get(i).get(i);
		}

		// function
		for (int row = 1; row < size; row++) {
			int listSize = triangle.get(row).size();
			for (int col = 1; col < listSize - 1; col++) {
				func[row][col] = triangle.get(row).get(col) + Math.min(func[row - 1][col - 1], func[row - 1][col]);
			}
		}

		// answer
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < size; j++) {
			if (min > func[size - 1][j]) {
				min = func[size - 1][j];
			}
		}
		return min;
	}
}