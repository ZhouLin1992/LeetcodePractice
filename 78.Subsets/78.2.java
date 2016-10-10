public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());

		for(int num: nums) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for (List<Integer> sub: res) {
				List<Integer> t = new ArrayList<Integer>(sub);
				t.add(num);
				tmp.add(t);
			}
			res.addAll(tmp);
		}
		return res;
	}
}