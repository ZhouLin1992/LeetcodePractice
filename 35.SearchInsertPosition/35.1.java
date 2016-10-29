public class Solution {
    public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;

		int lo = 0, hi = nums.length - 1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				lo = mid;
			else 
				hi = mid;
		}

// find the first position >= target
		if (nums[lo] >= target)
			return lo;

		if (nums[hi] >= target)
			return hi;

		return hi + 1;        
    }
}