public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		for (int row = 0; row <= rowIndex; row++) {
			if (row == 0) list.add(1);
			if (row > 0) {
				int prev = 1, curr;
				for (int col = 1; col < row; col++) {
					curr = list.get(col);
					list.set(col, prev + curr);
					prev = curr;
				}
				list.add(1);
			}
		}
		return list;
    }
}