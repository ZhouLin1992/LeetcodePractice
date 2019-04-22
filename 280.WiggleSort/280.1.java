/*
space: o(1)
time: o(N), worse case n/2 times (e.g. [2,1,3,1,4,1])
*/

class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && (nums[i - 1] > nums[i]) || i % 2 == 0 && (nums[i - 1] < nums[i])) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}