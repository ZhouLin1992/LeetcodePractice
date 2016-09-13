public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			res.add((int)((long)res.get(i - 1) * (rowIndex - i + 1) / i));
		}
		return res;
    }
}