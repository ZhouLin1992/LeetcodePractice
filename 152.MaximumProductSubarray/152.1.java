public class Solution {
	public int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;

		// store the previous local largest/smallest
		int preMax = nums[0];
		int preMin = nums[0];
		// store the global largest
		int maxSoFar = nums[0];
		// store the current local largest/smallest
		int localMax, localMin;

		for (int i = 1; i < nums.length; i++) {
			localMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
			localMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
			maxSoFar = Math.max(localMax, maxSoFar);
			preMax = localMax;
			preMin = localMin;
		}

		return maxSoFar;
	}
}