// 适用于更多情况

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int len = nums.length;
        int k = 2;
        if (len <= 2) {
            return len;
        }
        
        int j = 1;
        int count = 1;
        
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count <= k) {
                    nums[j++] = nums[i];
                }
            } else {
                count = 1;
                nums[j++] = nums[i];
            }
        }
        
        return j;
    }
}