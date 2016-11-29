public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        
        // sort, because need to check duplicates
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - sum);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    if (target - tmp < diff) {
                        sum = tmp;
                        diff = target - tmp;
                    }
                    // at least need to plus once
                    do {
                        left++;                        
                    } while (left > i + 1 && left < right && nums[left] == nums[left - 1]);
                } else {
                    if (tmp - target < diff) {
                        sum = tmp;
                        diff = tmp - target;
                    }
                    // at least need to minus once
                    do {
                        right--;
                    } while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]);
                }
            }
        }
        return sum;
    }
}