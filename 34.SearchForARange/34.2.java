public class Solution {
    public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] {-1, -1};

		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target) {
				if (nums[hi] > target)
					hi--;
				else if (nums[lo] < target)
					lo++;
				else 
					return new int[] {lo, hi};
			} else if (nums[mid] < target) {
				lo = mid + 1;
			} else
				hi = mid - 1;
		}
		return new int[] {-1, -1};      
    }
}