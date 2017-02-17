/*
When meet some problem, which required to check / get the sub-continuous-array 
or sub-continuous-string, we should always think about Slide Window Algorithm.

思路 - 滑动窗口法：
1.如果发现了一个[i,j], sum >= s, 那么之后的[i, j+1], [i, j+2]....都不用看了。
保持j的位置，减去i的元素直到找到一个新的符合条件的subarray
2.使用两个下标start和end标识窗口（子数组）的左右边界,end向后走,直到sum大于s。
然后start向后, 直到sum小于s。同时更新min值。

时间: O(N)
空间: O(1)
*/

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
            // j后面的元素都不用看了，加上后面的元素肯定比target大
            // 但是长度肯定比现有的长
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