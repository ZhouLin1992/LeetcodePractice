// Divide & Conquer:
// 1. Divide the array into two parts.
// 2. Find maximum subarray sum for left half recursively.
// 3. Find maximum subarray sum for right half recursively.
// 4. Find maximum subarray sum for the subarray including the middle element. (Sum of last two steps)
// 5. Return the maximum of the last three results.
public class Solution {
	public int maxSubArray(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return Integer.MIN_VALUE;
	    }
	    
	    if (nums.length == 1) {
	        return nums[0];
	    }
	    
        return maxSubArrayHelper(nums, 0, nums.length - 1);
	}

	private int maxSubArrayHelper(int[] nums, int start, int end) {
		if (start > end) {
			return 0;
		}

		if (start == end) {
			return Math.max(Integer.MIN_VALUE, nums[start]);
		}

		int mid = start + (end - start) / 2;

		// left-crossing
		int leftMax = Integer.MIN_VALUE, leftSum = 0;
		for (int i = mid; i >= start; i--) {
			leftSum += nums[i];
			if (leftMax < leftSum) {
				leftMax = leftSum;
			}
		}

		// right-crossing
		int rightMax = Integer.MIN_VALUE, rightSum = 0;
		for (int i = mid + 1; i <= end; i++) {
			rightSum += nums[i];
			if (rightMax < rightSum) {
				rightMax = rightSum;
			}
		}

		return Math.max(leftMax + rightMax, Math.max(maxSubArrayHelper(nums, start, mid), maxSubArrayHelper(nums, mid + 1, end)));
	}
}
