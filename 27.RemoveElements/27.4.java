/*
Two pointers (when elemenets to remove are rare, in 27.3 it will be a waste of time to do copy operations),
in this approach, the number of assignment operation is equal to the number of elements to be moved
Time: O(n)
Space: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        
        return len;
    }
}