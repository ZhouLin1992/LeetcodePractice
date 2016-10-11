public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		res.add(new LinkedList<Integer>());

		for (int n: nums) {
			int size = res.size();
			for (; size > 0; size--) {
				List<Integer> tmp = res.pollFirst();
				for (int i = 0; i <= tmp.size(); i++) {
					List<Integer> r = new LinkedList<Integer>(tmp);
					r.add(i, n);
					res.add(r);				    
				}
			}
		}
		return res;
	}
}