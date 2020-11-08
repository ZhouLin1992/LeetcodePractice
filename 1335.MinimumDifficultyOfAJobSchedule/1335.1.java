/**
https://www.youtube.com/watch?v=eRBpfoWujQM
帮助理解
(k-1) days      (1) day
 1.....j       j+1.....i
dp[j][k-1]   max(jobs[j+1~i])

time:o(N*N*d)
space:o(N*d)
**/

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty == null || jobDifficulty.length == 0 || jobDifficulty.length < d) {
            return -1;
        }
        
        // min difficulty sum to schedule (i) jobs in (d) days, j and d are 0-index based
        int[][] dp = new int[d][jobDifficulty.length];
        
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < jobDifficulty.length; i++) {
            // on day 0, take the maximum difficulty from (1~i)th jobs
            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
        }
        
        for (int day = 1; day < d; day++) {
            // job counts at least need to be day counts
            for (int i = day; i < jobDifficulty.length; i++) {
                int localMax = jobDifficulty[i];
                dp[day][i] = Integer.MAX_VALUE;
                for (int j = i; j >= day; j--) {
                    // get the maximum localMax on the go
                    localMax = Math.max(localMax, jobDifficulty[j]);
                    dp[day][i] = Math.min(dp[day][i], dp[day - 1][j - 1] + localMax);
                }
            }
        }
        
        return dp[d - 1][jobDifficulty.length - 1];
    }
}