public class Solution {
	public int maxProduct(int[] nums) {
		int product = 1;
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			product = nums[i] == 0 ? 1 : product * nums[i];
			max = Math.max(max, nums[i] == 0 ? 0 : product);
		}

        product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			product = nums[i] == 0 ? 1 : product * nums[i];
			max = Math.max(max, nums[i] == 0 ? 0 : product);
		}
		return max;
	}
}