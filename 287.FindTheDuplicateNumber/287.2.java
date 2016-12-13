// Time complexity: O(NlogN)
// Space complexity: O(1)
// the range is [low, (mid), high]
// count is to count the total numbers at the range [low, mid]
// if count <= mid, means that duplicate number is not in the range [low, mid]
// if count > mid, means that duplicate number is in the range [low, mid]

public class Solution {
	public int findDuplicate(int[] nums) {
		int low = 1, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}
			if (count <= mid) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}