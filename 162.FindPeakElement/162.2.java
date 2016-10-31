public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int midNum = nums[mid];
            if (midNum > nums[mid - 1] && midNum > nums[mid + 1])
                return mid;
            else if (midNum > nums[mid - 1] && midNum < nums[mid + 1])
                lo = mid;
            else if (midNum < nums[mid - 1] && midNum > nums[mid + 1])
                hi = mid;
            else 
                lo = mid;
        }
        
        if (nums[lo] < nums[hi])
            return hi;
        return lo;
    }
}