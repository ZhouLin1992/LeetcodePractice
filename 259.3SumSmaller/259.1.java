class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int i = 0;
        int result = 0;
        int len = nums.length;
        while (i < len - 2) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    result += right - left;
                    left++;
                } else {
                    right--;
                }
            }
            i++;
        }
        
        return result;
    }
}