public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int lo = 0, hi = nums.length - 1, idx = 0;
		if (nums[lo] < nums[hi])
			return binarySearch(nums, target, lo, hi);
		else {
			int len = nums.length - 1;
			int endNum = nums[len];
			while (lo + 1 < hi) {
				int mid = lo + (hi - lo) / 2;
				if (nums[mid] > endNum)
					lo = mid;
				else
					hi = mid;
			}
			idx = nums[lo] < nums[hi] ? lo : hi;
			if (nums[idx] == target)
				return idx;
			else if (target <= endNum)
				return binarySearch(nums, target, idx, len);
		}
		return binarySearch(nums, target, 0, idx);
	}

	public int binarySearch(int[] nums, int target, int lo, int hi) {
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				lo = mid;
			else
				hi = mid;
		}
		if (nums[lo] == target)
			return lo;
		else if (nums[hi] == target)
			return hi;
		return -1;
	}
}