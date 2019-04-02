class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        
        int len = nums.length;
        int[] newArr = new int[len];
        
        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }
        
        for (int i = 0; i < len; i++) {
            nums[i] = newArr[i];
        }
    }
}