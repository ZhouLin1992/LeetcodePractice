public class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k % nums.length == 0) return;
		int[] newNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			newNums[i] = nums[(i - k) % nums.length >= 0 ? (i - k) % nums.length : (i - k) % nums.length + nums.length];
		for (int i = 0; i < nums.length; i++) nums[i] = newNums[i];
	}
}