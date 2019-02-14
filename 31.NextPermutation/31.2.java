class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
        	return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
        	i--;
        }

        if (i >= 0) {
			int j = findLargerThan(nums, i);
    		swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
    	while (start < end) {
    		swap(nums, start, end);
    		start++;
    		end--;
    	}
    }

    private int findLargerThan(int[] nums, int i) {
    	int start = i + 1;
    	int end = nums.length - 1;

    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] <= nums[i]) {
    			end = mid - 1;
    		} else {
    			start = mid;
    		}
    	}

    	if (nums[end] > nums[i]) {
    		return end;
    	}

    	return start;
    }
}