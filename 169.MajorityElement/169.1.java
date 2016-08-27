public class Solution {
	public int majorityELement(int[] nums) {
		int maj = nums[0], count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maj == nums[i]) count++;
			else if (count == 0) {
				count = 1;
				maj = nums[i];
			} else count--;
		}
		return maj;
	}
}