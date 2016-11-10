// might be TLE

public class Solution {
	public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // state: the number of jumps to reach an index
        // initialize: counts[0] = 0
        int[] counts = new int[nums.length];
        
        // function
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (counts[j] == 0) {
                    counts[j] = counts[i] + 1;
                } else {
                    counts[j] = Math.min(counts[i] + 1, counts[j]);
                }
            }
        }
        return counts[nums.length - 1];
	}
}