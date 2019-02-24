class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count <= 2) {
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