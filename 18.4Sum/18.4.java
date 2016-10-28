public class Solution {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums);
		return kSum(nums, target, 4, 0);
	}

	public static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
		List<List<Integer>> res = new ArrayList<>();
		if (start >= nums.length)
			return res;

		if (k == 2) {
			int lo = start, hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[lo] + nums[hi];
				if (sum == target) {
					// Arrays.asList returning a fixed size of list, can't add/ remove/ modify the list.
					// if using res.add(Arrays.asList(...)), later it can't be modified.
					List<Integer> list = new ArrayList<>(Arrays.asList(nums[lo], nums[hi]));
					res.add(list);
					do {
						lo++;
					} while (lo < hi && nums[lo] == nums[lo - 1]);
					do {
						hi--;
					} while (lo < hi && nums[hi] == nums[hi + 1]);
				} else if (sum < target) {
					do {
						lo++;
					} while (lo < hi && nums[lo] == nums[lo - 1]);
				} else {
					do {
						hi--;
					} while (lo < hi && nums[hi] == nums[hi + 1]);
				}
			}
		} else {
			for (int i = start; i < nums.length - k + 1; i++) {
				if (i > start && nums[i] == nums[i - 1]) 
					continue;
					List<List<Integer>> tmp = kSum(nums, target - nums[i], k - 1, i + 1);
					if (tmp != null) {
						for (List<Integer> l: tmp) {
							l.add(0, nums[i]);
						}
						res.addAll(tmp);
					}					
			}
		}
		return res;
	}
}