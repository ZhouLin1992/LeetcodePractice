public class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int left = 0, right = nums.length - 1;
		for (int i = 0; i <= right; i++) {
		    // element '2' has to be checked first
		    // because after swap
		    // still needs to check element at i
		    // since it is not sure whether element at i
		    // is '0' or '1'
			while (nums[i] == 2 && i < right) {
				swap(nums, i, right--);
			}
			while (nums[i] == 0 && left < i) {
				swap(nums, i, left++);
			}
		}
	}

	private void swap(int[] nums, int i, int p) {
		if (i == p) {
			return;
		}

		int tmp = nums[i];
		nums[i] = nums[p];
		nums[p] = tmp;
	}
}