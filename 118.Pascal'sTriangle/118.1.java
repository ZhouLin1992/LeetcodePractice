public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pt = new ArrayList<>();
		for (int row = 0; row < numRows; row++) {
			pt.add(new ArrayList<Integer>());
			if (row == 0) pt.get(row).add(1);
			if (row == 1) {
				pt.get(row).add(1);
				pt.get(row).add(1);
			}
			if (row > 1) {
				pt.get(row).add(1);
				for (int col = 1; col < row; col++) {
					pt.get(row).add(pt.get(row - 1).get(col - 1) +
						pt.get(row - 1).get(col));
				}
				pt.get(row).add(1);
			}
		}
		return pt;
	}
}