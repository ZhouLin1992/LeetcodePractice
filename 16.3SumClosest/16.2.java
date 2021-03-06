public class Solution {
    public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return Integer.MAX_VALUE;
		}
        
        // in order to check duplicates
        Arrays.sort(nums);
		int sum = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int tmp = nums[i] + nums[left] + nums[right];
				if (Math.abs(tmp - target) < Math.abs(sum - target)) {
					sum = tmp;
				}
				if (tmp < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return sum;
    }
}