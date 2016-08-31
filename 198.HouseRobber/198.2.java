public class Solution {
    public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int no = 0, yes = 0, temp;
		for (int i = 0; i < nums.length; i++) {
		    temp = yes;
			yes = no + nums[i];
			no = Math.max(no, temp);
		}
		return Math.max(yes, no);
    }
}