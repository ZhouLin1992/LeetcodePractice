public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// state: dp[index] (len = index + 1) refers to the smallest element it can be
		// at the last index if the length of LIS is len;
		// the state array is in increasing order
		int[] dp = new int[nums.length];

		// initialize
		dp[0] = nums[0];
		// the initialization of the max length is (0 + 1) = 1
		int maxLen = 0;

		// function
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < dp[0]) {
				dp[0] = nums[i];
			} else if (nums[i] > dp[maxLen]) {
				maxLen++;
				dp[maxLen] = nums[i];
			} else {
				binarySearch(dp, nums[i], maxLen);
			}
		}
		return maxLen + 1;
	}

	private void binarySearch(int[] dp, int element, int len) {
		int start = 0;
		int end = len;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (dp[mid] < element) {
				start = mid;
			} else if (dp[mid] == element) {
				return;
			} else {
				end = mid;
			}
		}

		if (dp[start] >= element) {
			dp[start] = element;
			return;
		}

		if (dp[end] >= element) {
			dp[end] = element;
		}
	}
}