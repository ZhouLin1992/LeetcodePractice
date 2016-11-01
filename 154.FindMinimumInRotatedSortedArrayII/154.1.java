// Worst case is [1, 1, 1...0, 1, 1...1];
// Time complexity is O(n)

public class Solution {
    public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		int len = nums.length;
		int lo = 0;
		int hi = len - 1;

		if (nums[0] < nums[hi])
			return nums[0];
		else {
			while (lo + 1 < hi) {
				int mid = lo + (hi - lo) / 2;
				if (nums[mid] < nums[hi])
					hi = mid;
				else if (nums[mid] > nums[hi])
					lo = mid;
				else 
					hi--;
			}
		}
		return Math.min(nums[lo], nums[hi]);        
    }
}