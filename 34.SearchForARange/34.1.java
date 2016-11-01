public class Solution {
    public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] {-1, -1};

		// the left bound
		int lo = 0, hi = nums.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				hi = mid;
			else if (nums[mid] < target)
				lo = mid;
			else
				hi = mid;
		}

		int left = 0;
		if (nums[lo] == target)
			left = lo;
		else if (nums[hi] == target)
			left = hi;
		else
			return new int[] {-1, -1};

        // the right bound
		lo = 0;
		hi = nums.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				lo = mid;
			else if (nums[mid] > target)
				hi = mid;
			else
				lo = mid;
		}

		int right = 0;
		if (nums[hi] == target)
			right = hi;
		else if (nums[lo] == target)
			right = lo;

		return new int[] {left, right};        
    }
}