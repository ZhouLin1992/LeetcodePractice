public class Solution {
    public List<Integer> getRow(int rowIndex) {
		int[] res = new int[rowIndex + 1];
		res[0] = 1;
		for (int row = 1; row <= rowIndex; row++) {
			res[row] = 1;
			for (int col = row - 1; col > 0; col--) {
				res[col] += res[col - 1];
			}
		}
		List<Integer> arrlst = new ArrayList<Integer>();
		for (int i: res)
			arrlst.add(i);
		return arrlst;
    }
}