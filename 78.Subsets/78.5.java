public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		subsets(nums, 0, new ArrayList<Integer>());
		return res;
	}

	public void subsets(int[] nums, int start, ArrayList<Integer> tmp) {
		res.add(new ArrayList<Integer>(tmp));

		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			subsets(nums, i + 1, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}