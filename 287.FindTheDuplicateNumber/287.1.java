// Time complexity: O(NlogN)
// Space complexity: O(1)

public class Solution {
	public int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}
			// it is "<=" not "==", corner case [2, 2, 2, 2, 2]
			if (count <= mid) {
				low = mid + 1;
			} else {
				// it is "mid - 1" not "mid", corner case [1, 1]
				high = mid - 1;
			}
		}
		return low;
	}
}