public class Solution {
    public int rob(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	public int rob(int[] nums, int lo, int hi) {
		int yes = 0, no = 0, tmp;
		for (int i = lo; i <= hi; i++) {
			tmp = yes;
			yes = no + nums[i];
			no = Math.max(tmp, no);
		}
		return Math.max(yes, no);        
    }
}