// (forward thinking) scan the array, record the farthest index which can be reached

public class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		// farthest index which can be reached
		int canReach = 0;
		for (int i = 0; i < n && i <= canReach; i++) {
			canReach = Math.max(canReach, i + nums[i]);
			if (canReach >= n - 1) {
				return true;
			}
		}
		return false;
	}
}