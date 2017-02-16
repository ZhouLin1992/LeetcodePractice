/*
Binary Search Algorithm:
Initial another array with the length to be nums.length + 1, 
and sum[i] is equal to the sum from nums[0] to nums[i - 1], when meets an index, 
for example, sum[i + 1] is larger or equal to s, then find the largest index that 
smaller than (sum[i + 1] - target) by using binary search.
If find, length = i + 1 - index

时间：
O(NlogN)
空间：
O(N)
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] sum = new int[len + 1];
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
            if (sum[i + 1] >= s) {
                int left = binarySearch(sum, sum[i + 1] - s, 0, i + 1);
                res = Math.min(res, i + 1 - left);
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    private int binarySearch(int[] sum, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (sum[mid] == target) {
                start = mid;
            } else if (sum[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (sum[end] <= target) {
            return end;
        }
        return start;
    }
}