class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length < 2) {
            return nums.length;
        }
        
        int start = 1;
        while (start <= nums.length - 1 && nums[start] == nums[start - 1]) {
            start++;
        }
        if (start == nums.length) {
            return 1;
        }
        
        // denote if we are expecting increase or decrease
        boolean increasing = nums[start] > nums[0];
        int count = 1;
        for (int i = start; i < nums.length; i++) {
            if (increasing && nums[i] > nums[i - 1] || !increasing && nums[i] < nums[i - 1]) {
                increasing = !increasing;
                count++;
            }
        }
        
        return count;
    }
}