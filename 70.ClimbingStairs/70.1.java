public class Solution {
    public int climbStairs(int n) {
		if (n < 0) return 0;
		if (n == 1 || n == 2 || n == 3) return n;
		int two_steps_before = 2,
		    one_step_before = 3,
		    res = 0;
		for (int i = 4; i <= n; i++) {
			res = two_steps_before + one_step_before;
			two_steps_before = one_step_before;
			one_step_before = res;		
		}
		return res;	
    }
}