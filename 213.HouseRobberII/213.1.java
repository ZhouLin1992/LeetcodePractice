public class Solution {
    public int rob(int[] nums) {
		if (nums.length == 0 || nums == null) return 0;
		if (nums.length == 1) return nums[0];
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	public int rob(int[] nums, int lo, int hi) {
	    if (hi == lo) 
	        return nums[lo];
		int[] res = new int[hi - lo + 1];
		res[0] = nums[lo];
		res[1] = Math.max(nums[lo], nums[lo + 1]);
		for (int i = 2; i <= hi - lo; i++) 
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i + lo]);
		return res[res.length - 1];        
    }
}