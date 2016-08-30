public class Solution {
    public int singleNumber(int[] nums) {
		int ref = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ref ^= nums[i];
		}
		return ref;
    }
}