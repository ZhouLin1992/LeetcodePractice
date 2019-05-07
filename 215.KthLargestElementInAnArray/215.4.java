class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) {
            return Integer.MIN_VALUE;
        }
        
        int index = helper(nums, 0, nums.length - 1, k - 1);
        return nums[index];
    }
    
    private int helper(int[] nums, int start, int end, int k) {
        if (start == end) {
            return start;
        }
        
        int pos = quickSort(nums, start, end);
        if (pos == k) {
            return pos;
        } else if (pos < k) {
            return helper(nums, pos + 1, end, k);
        } else {
            return helper(nums, start, pos - 1, k);
        }
    }
    
    // descending sort
    private int quickSort(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        int right = end;
        
        while (left < right) {
            while (left < right && pivot >= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            
            while (left < right && pivot <= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
}