public class Solution {
	public void moveZeros(int[] nums) {
		int zeroCounts = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) zeroCounts++;
			else nums[i - zeroCounts] = nums[i];
		}
		while (zeroCounts > 0) nums[nums.length - zeroCounts--] = 0;
	}
}