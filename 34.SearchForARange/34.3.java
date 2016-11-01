public class Solution {
    public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] {-1, -1};
		int[] range = {nums.length, -1};
		searchRange(nums, target, 0, nums.length - 1, range);
		if (range[0] > range[1]) 
			range[0] = -1;
		return range;
	}

	public void searchRange(int[] nums, int target, int left, int right, int[] range) {
		if (left > right) return;
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			if (mid < range[0]) {
				range[0] = mid;
				searchRange(nums, target, left, mid - 1, range);
			}
			if (mid > range[1]) {
				range[1] = mid;
				searchRange(nums, target, mid + 1, right, range);
			}
		} else if (nums[mid] < target) {
			searchRange(nums, target, mid + 1, right, range);			
		} else {
			searchRange(nums, target, left, mid - 1, range);			
		}   
    }
}