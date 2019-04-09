class Solution {
    public int rob(int[] nums) {
        // f(-1) = 0
        int prev = 0;
        // f(0) = 0
        int curr = 0;
        for (int num : nums) {
            int tmp = curr;
            curr = Math.max(prev + num, curr);
            prev = tmp;
        }
        
        return curr;
    }
}