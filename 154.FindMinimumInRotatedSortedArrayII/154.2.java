public class Solution {
    public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int len = nums.length;
		int lo = 0, hi = len - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi])
				lo = mid;
			else if (nums[mid] < nums[hi])
				hi = mid;
			else {
				if (nums[mid] == nums[lo]) {
					lo++;
					hi--;
				} else 
					hi = mid;
			}
		}
		return Math.min(nums[lo], nums[hi]);      
    }
}