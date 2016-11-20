// Kadane's algorithm: Kadane's algorithm consists of a scan through 
// the array values, computing at each position the maximum (positive sum) 
// subarray ending at that position.
// This subarray is either empty (in which case its sum is zero) or consists 
// of one more element than the maximum subarray ending at the previous 
// position.

public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int maxEndingHere = nums[0], maxSoFar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// maxEndingHere can defined as 
			// maxEndingHere = Math.max(maxEndingHere + nums[i], 0 + nums[i]);
			// local maximum
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			// global maximum
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
}