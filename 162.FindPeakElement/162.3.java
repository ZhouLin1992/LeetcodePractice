public class Solution {
    public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				return i - 1;
		}
		return nums.length - 1;
    }
}