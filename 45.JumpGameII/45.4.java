/*
https://leetcode.windliang.cc/leetCode-45-Jump-Game-II.html

time: o(n^2), worse case
space: o(1)
worse case: nums = [1,1,1,1,1,1]
*/

class Solution {
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;
        
        while (pos != 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] >= pos - i) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        
        return step;
    }
}