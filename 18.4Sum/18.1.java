// There are too many input, it will be TLE

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		fourSum(nums, 0, 4, target, res, new ArrayList<Integer>());
		return res;
	}

	public void fourSum(int[] nums, 
						int start, 
						int count, 
						int target,
						List<List<Integer>> res,
						List<Integer> cur) {

		if (target == 0 && count == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = start; i <= nums.length - count && count > 0; i++) {
			if (i != start && nums[i] == nums[i - 1])
				continue;
			cur.add(nums[i]);
			fourSum(nums, i + 1, count - 1, target - nums[i], res, cur);
			cur.remove(cur.size() - 1);
		}
	}
}