// modified a bit of 45.2

public class Solution {
	public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
		int last = 0;
		int cur = 0;
		int steps = 0;
        
		// since the question indicates that last index can always be reached
		// no need to check whether i is smaller than nums.length because no matter what
		// cur >= nums.length - 1 will be achieved
		for (int i = 0; cur < nums.length - 1; i++) {
			if (i > last) {
				steps++;
				last = cur;
			}
			cur = Math.max(cur, nums[i] + i);
		}
		return steps + 1;
	}
}