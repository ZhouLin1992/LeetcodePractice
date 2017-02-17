/*
滑动窗口方法二
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0, j = 0, sum = 0;
        int res = Integer.MAX_VALUE;
        
        while (i < nums.length && j < nums.length) {
            while (sum < s && j < nums.length) {
                sum += nums[j];
                j++;
            }
            while (i <= j && sum >= s) {
                res = Math.min(res, j - i);
                sum -= nums[i++];
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}