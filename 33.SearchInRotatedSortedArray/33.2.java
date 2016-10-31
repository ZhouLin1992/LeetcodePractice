public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int lo = 0;
		int hi = nums.length - 1;
		int mid;

		while (lo + 1 < hi) {
			mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[mid] < nums[hi]) {
				if (target >= nums[mid] && target <= nums[hi])
					lo = mid;
				else 
					hi = mid;
			} else {
				if (target >= nums[lo] && target <= nums[mid])
					hi = mid;
				else 
					lo = mid;
			}
		}
		
		if (nums[lo] == target)
			return lo;

		if (nums[hi] == target)
			return hi;

		return -1;
	}
}