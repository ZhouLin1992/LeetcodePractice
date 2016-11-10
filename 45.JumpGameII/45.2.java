// try to find the maximum distance each jump can reach

public class Solution {
	public int jump(int[] nums) {
		// last: distance that last jump already covered
		// initialize: at the beginning, no distance has already covered
		int last = 0;

		// cur: currently the longest distance a jump can be covered
		int cur = 0;

		// count the minimum steps
		int steps = 0;

		for (int s = 0; s < nums.length; s++) {
			// s has already stepped out current covered range
			if (s > last) {
				last = cur;
				steps++;
			}
			cur = Math.max(cur, nums[s] + s);
		}
		return steps;
	}
}