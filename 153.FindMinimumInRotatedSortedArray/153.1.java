public class Solution {
    public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums[nums.length - 1] > nums[0])
			return nums[0];

		int lo = 0, hi = nums.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi])
				lo = mid;
			else 
				hi = mid;
		}

		return Math.min(nums[lo], nums[hi]);        
    }
}