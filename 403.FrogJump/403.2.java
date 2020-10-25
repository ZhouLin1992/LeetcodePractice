// https://leetcode.com/problems/frog-jump/discuss/193816/Concise-and-fast-DP-solution-using-2D-array-instead-of-HashMap-with-text-and-video-explanation.

class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        int len = stones.length;
        // dp: for index x, whether the frog can make jump of size y
        boolean[][] steps = new boolean[len][len];
        steps[0][1] = true;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = stones[i] - stones[j];
                if (diff >= len || !steps[j][diff]) {
                    continue;
                }
                
                steps[i][diff] = true;
                if (diff - 1 > 0) {
                    steps[i][diff - 1] = true;
                }
                if (diff + 1 < len) {
                    steps[i][diff + 1] = true;
                }
                
                if (i == len - 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}