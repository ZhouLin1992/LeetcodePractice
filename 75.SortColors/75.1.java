public class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int i = 0;
		int pl = 0;
		int pr = nums.length - 1;
		while (i <= pr) {
		    // i element == 0 needs to be at the left part of the array
		    // and pointer i needs to move forward 1
			if (nums[i] == 0) {
				swap(nums, i, pl);
				pl++;
				i++;
			// i element == 2 needs to be at the right part of the array
			// and pointer i can not be moved because after swap
			// not sure whether i element is 0 or 1
			} else if (nums[i] == 2) {
				swap(nums, i, pr);
				pr--;
			// i element == 1 needs to be at the middle of the array
			// pointer i needs not to swap
			} else {
			    i++;
			}
		}
	}
    
    // function for swap
	private void swap(int[] nums, int i, int p) {
		if (i == p) {
			return;
		}

		int tmp = nums[i];
		nums[i] = nums[p];
		nums[p] = tmp;
	}
}