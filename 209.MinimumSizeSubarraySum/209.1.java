public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        
        for (i = 0; i < nums.length; i++) {
            while (sum < s && j < nums.length) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                res = Math.min(res, j - i);
            }
            sum -= nums[i];
        }
        
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}