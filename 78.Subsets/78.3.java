public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		for (int num: nums) {
			int tmpSize = res.size();
			// for-each loop can not be used; ConcurrentModificationException is thrown
			for (int i = 0; i < tmpSize; i++) {
				List<Integer> tmp = new ArrayList<>(res.get(i));
				tmp.add(num);
				res.add(tmp);
			}
		}
		return res;
	}
}