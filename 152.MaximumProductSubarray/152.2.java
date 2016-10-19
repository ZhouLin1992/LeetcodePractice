public class Solution {
	public int maxProduct(int[] nums) {
		int max	= nums[0];

		for (int i = 1, lmin = nums[0], lmax = nums[0]; i < nums.length; i++) {
			if (nums[i] < 0) {
				lmin ^= lmax;
				lmax ^= lmin;
				lmin ^= lmax;
			}

			lmax = Math.max(lmax * nums[i], nums[i]);
			lmin = Math.min(lmin * nums[i], nums[i]);
			max = Math.max(max, lmax);
		}

		return max;
	}
}