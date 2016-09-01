public class Solution {
    public int removeDuplicates(int[] nums) {
    	if (nums.length == 0 || nums == null) return 0;
    	if (nums.length == 1) return 1;
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j++] = nums[i];
			}
		}
		return j;
    }
}