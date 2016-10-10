public class Solution {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k) {
		combine(n, k, 1, new ArrayList<Integer>());
		return res;
	}

	public void combine(int n, int k, int start, ArrayList<Integer> cur) {
		if (k > 0) {
			for (int i = start, max = n - k + 1; i <= max; i++) {
				cur.add(i);
				combine(n, k - 1, i + 1, cur);
				cur.remove(cur.size() - 1);
			}
		} else
			res.add(new ArrayList<Integer>(cur));
	}
}