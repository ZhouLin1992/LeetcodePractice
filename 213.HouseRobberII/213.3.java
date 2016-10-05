public class Solution {
    public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);

		int firstIn = nums[0];
		int firstEx = 0;
		int nonFirstIn = 0;
		int nonFirstEx = 0;

		for (int i = 1; i < nums.length; i++) {
			int tmpFirst = firstIn;
			firstIn = firstEx + nums[i];
			firstEx = Math.max(firstEx, tmpFirst);

			int tmpNFirst = nonFirstIn;
			nonFirstIn = nonFirstEx + nums[i];
			nonFirstEx = Math.max(nonFirstEx, tmpNFirst);
		}
		return Math.max(firstEx, nonFirstIn);       
    }
}