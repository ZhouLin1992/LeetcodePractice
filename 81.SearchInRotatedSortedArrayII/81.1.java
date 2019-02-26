/*
worse case - [1,1,1,1,1,1.....1]
time: o(n)
*/

class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
        	return false;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] == target) {
        		return true;
        	}
        	if (nums[start] < nums[mid]) {
        		if (nums[start] <= target && target <= nums[mid]) {
        			end = mid;
        		} else {
        			start = mid;
        		}
        	} else if (nums[start] > nums[mid]) {
        		if (nums[mid] <= target && target <= nums[end]) {
        			start = mid;
        		} else {
        			end = mid;
        		}
        	} else {
        		// avoid duplicates
        		start++;
        	}
        }

        if (nums[start] == target || nums[end] == target) {
        	return true;
        }

        return false;
    }
}