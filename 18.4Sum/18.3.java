public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums);

		int max = nums[nums.length - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];
			if (i > 0 && tmp == nums[i - 1])
				continue;
			if (tmp + 3 * max < target)
				continue;
			if (4 * tmp > target)
				break;
			if (4 * tmp == target) {
				if (i + 3 < nums.length && nums[i + 3] == tmp) {
					res.add(Arrays.asList(tmp, tmp, tmp, tmp));
					break;
				}
			}
			threeSumForFourSum(nums, res, target - tmp, i + 1, tmp);
		}
		return res;
	}

	public void threeSumForFourSum(int[] nums, List<List<Integer>> res, int target, int start, int e1) {
		if (start + 1 >= nums.length - 1)
			return;

		int max = nums[nums.length - 1];
		if (3 * nums[start] > target || 3 * max < target)
			return;

		for (int i = start; i < nums.length; i++) {
			int e2 = nums[i];
			if (i > start && e2 == nums[i - 1])
				continue;
			if (e2 + 2 * max < target)
				continue;
			if (3 * e2 > target)
				break;
			if (3 * e2 == target) {
				if (i + 2 < nums.length && nums[i + 2] == e2) {
					res.add(Arrays.asList(e1, e2, e2, e2));
					break;
				}
			}
			twoSumForFourSum(nums, res, target - e2, i + 1, e1, e2);
		}
	}

	public void twoSumForFourSum(int[] nums, List<List<Integer>> res, int target, int start, int e1, int e2) {
		if (start >= nums.length - 1)
			return;

		int max = nums[nums.length - 1];
		if (2 * nums[start] > target || 2 * max < target)
			return;

		int left = start, right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				res.add(Arrays.asList(e1, e2, nums[left], nums[right]));
				do {
					left++;
				} while (left < right && nums[left] == nums[left - 1]);
				do {
					right--;
				} while (left < right && nums[right] == nums[right + 1]);
			} else if (sum < target) {
				do {
					left++;
				} while (left < right && nums[left] == nums[left - 1]);
			} else {
				do {
					right--;
				} while (left < right && nums[right] == nums[right + 1]);
			}
		}
		return;
	}
}