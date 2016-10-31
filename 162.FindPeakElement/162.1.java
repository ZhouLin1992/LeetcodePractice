public class Solution {
    public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) 
			return -1;

		int lo = 0, hi = nums.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] < nums[mid - 1]) 
				hi = mid;
			else if (nums[mid] < nums[mid + 1])
				lo = mid;
			else 
				return mid;
		}
		return nums[lo] < nums[hi] ? hi : lo;
    }
}