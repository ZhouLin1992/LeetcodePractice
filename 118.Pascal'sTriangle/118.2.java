public class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pt = new ArrayList<>();
		for (int row = 0; row < numRows; row++) {
			ArrayList lst = new ArrayList<Integer>();
			for (int col = 0; col <= row; col++) {
				if (col == 0 || col == row)
					lst.add(1);
				else 
					lst.add(pt.get(row - 1).get(col - 1) + pt.get(row - 1).get(col));
			}
			pt.add(lst);
		}
		return pt;
    }
}