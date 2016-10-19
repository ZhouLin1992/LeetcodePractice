public class Solution {
	public int maxProduct(int[] nums) {
		int len = nums.length;
		int product = 1, max = nums[0];
		for (int i = 0; i < len; i++) {
			max = Math.max(product *= nums[i], max);
			if (nums[i] == 0) product = 1;
		}

        product = 1;
		for (int i = len - 1; i >= 0; i--) {
			max = Math.max(product *= nums[i], max);
			if (nums[i] == 0) product = 1;
		}
		return max;
	}
}