public class Solution {
    public int rob(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		int even = 0, odd  = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				even += nums[i];
				even = Math.max(even, odd);
			}
			if (i % 2 == 1) {
				odd += nums[i];
				odd = Math.max(even, odd);
			}
		}
		return Math.max(even, odd);
    }
}