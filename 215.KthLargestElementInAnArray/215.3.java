public class Solution {
	public int findKthLargest(int[] nums, int k) {
		for (int counter = 0; counter < k; counter++) {
			int maxIndex = counter;

			// find the index of the largest number
			for (int i = counter + 1; i < nums.length; i++) {
				if (nums[i] > nums[maxIndex]) {
					maxIndex = i;
				}
			}

			// the index of the largest number in the unsorted array
			// is counter
			if (maxIndex == counter) {
				continue;
			}

			// swap: counter and maxIndex
			int tmp = nums[maxIndex];
			nums[maxIndex] = nums[counter];
			nums[counter] = tmp;
		}

		return nums[k - 1];
	}
}