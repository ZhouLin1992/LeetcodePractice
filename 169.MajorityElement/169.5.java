// Bit Manipulation

public class Solution {
    public int majorityElement(int[] nums) {
        int[] cnt = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> (31 - i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] > nums.length / 2) {
                res += 1 << (31 - i);
            }
        }
        
        return res;
    }
}