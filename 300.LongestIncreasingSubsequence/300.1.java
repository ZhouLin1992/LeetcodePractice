public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return 1;
		}

		// state: at index i, the longest increasing subsequence (LIS) index i can get
		int[] LIS = new int[nums.length];

		// initialize: since every index can either be the beginning or the end of the subsequence, 
		// every index should be initialized as 1
		int max = 0;

		// function
		for (int i = 0; i < nums.length; i++) {
		    LIS[i] = 1;
			for (int j = 0; j < i; j++) {
		        if (nums[j] < nums[i]) {
    				if (LIS[j] + 1 > LIS[i]) {
    					LIS[i] = LIS[j] + 1;
    				}		            
		        }
			}
			if (LIS[i] > max) {
				max = LIS[i];
			}
		}
		return max;
	}
}