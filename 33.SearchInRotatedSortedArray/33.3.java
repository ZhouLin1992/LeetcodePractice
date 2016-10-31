public class Solution {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int lo = 0;
		int hi = nums.length - 1;
		
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[nums.length - 1])
				lo = mid;
			else
				hi = mid;
		}

		int rot = nums[lo] < nums[hi] ? lo : hi;
		lo = 0;
		hi = nums.length - 1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			int realMid = (mid + rot) % nums.length;
			if (nums[realMid] == target)
				return realMid;
			else if (nums[realMid] < target)
				lo = mid;
			else 
				hi = mid;
		}

		int realLo = (lo + rot) % nums.length;
		if (nums[realLo] == target)
			return realLo;

		int realHi = (hi + rot) % nums.length;
		if (nums[realHi] == target)
			return realHi;

		return -1;
	}
}