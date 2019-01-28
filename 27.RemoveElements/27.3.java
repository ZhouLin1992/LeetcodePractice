/*
Two pointers
Time: O(2*n)
Space: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = 0;
        for (int num : nums) {
            if (num != val) {
                nums[len++] = num;
            }
        }
        
        return len;
    }
}