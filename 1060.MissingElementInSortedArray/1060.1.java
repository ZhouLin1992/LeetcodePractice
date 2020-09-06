class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int missingCount = nums[high] - nums[0] - high;
        
        // 总体来看，如果缺的数 < k
        if (missingCount < k) {
            return nums[high] + k - missingCount;
        }
        
        // 总体来看，如果缺的数 > k
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int tempMissingCount = nums[mid] - nums[low] - (mid - low);
            
            if (tempMissingCount == k) {
                return nums[low] + k;
            } else if (tempMissingCount > k) {
                high = mid;
            } else {
                k -= tempMissingCount;
                low = mid;
            }
        }
        
        return nums[low] + k;
    }
}