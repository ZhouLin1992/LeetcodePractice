class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        /* 
        1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        we can ignore those because:
        if all numbers are (< 0) or (> n) then we'll simply return 1
        */
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }
        /*
        note: all numbers in the array are now positive, and in the range [1, n+1]
        */
        
        /*
        Traverse the array, each number we encountered in the array, convert index of this number (index = number) into negative
        */
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num > len) {
                continue;
            }
            num--; // minus 1 for zero index based array (so the number 1 will be at pos 0)
            // prevent duplicate negative operations
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }
        
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        // 4. no positive numbers were found, which means the array contains all numbers in the range of [1, n]
        return len + 1;
    }
}
