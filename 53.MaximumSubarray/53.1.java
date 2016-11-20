// prefix sum
public class Solution {
    public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE, minSum = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum - minSum);
			minSum = Math.min(minSum, sum);
		}

		return max;  
    }
}