public class Solution {
    public int missingNumber(int[] nums) {
        int tmp = 0, i = 1;
        while (i <= nums.length) tmp ^= i++;
        for (int num: nums) tmp ^= num;
        return tmp;
    }
}