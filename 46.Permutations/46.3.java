public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	public List<List<Integer>> permute(int[] nums) {

		if (nums.length == 0) return res;
		permute(nums, 0, new LinkedList<Integer>());
		return res;

	}

	public void permute(int[] nums, int i, LinkedList<Integer> cur) {

		if (i == nums.length) {
			res.add(new LinkedList<Integer>(cur));
			return;
		}

		for (int j = 0; j <= i; j++) {
			cur.add(j, nums[i]);
			permute(nums, i + 1, cur);
			cur.remove(j);
		}

	}
}