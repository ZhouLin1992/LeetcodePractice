class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        sum /= 2;

        /*
            For each element in nums, we can choose to pick it or not pick it. dp[i][j] means sum j can be
            sumed up by first i elements. If we can pick some numbers from 0-i whose sum is j, dp[i][j] is true;
            Otherwise it is false.
        */

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        // dp[0][0] is true; (zero number consists of sum 0 is true)
        dp[0][0] = true;
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        
        /*
            For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements 
            has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]). If we pick nums[i],
            dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and 
            the remaining composed of other previous numbers.
            Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]].
        */
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[nums.length][sum];
    }
}