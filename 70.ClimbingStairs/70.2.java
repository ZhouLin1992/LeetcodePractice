/*
Recursion with memoization
Time complexity: o(n)
Space complexity: o(n)
*/

class Solution {
    public int climbStairs(int n) {
        return climbStairs(0, n, new int[n + 1]);
    }
    
    public int climbStairs(int curr, int dest, int[] memo) {
        if (curr > dest) {
            return 0;
        }
        
        if (curr == dest) {
            return 1;
        }
        
        if (memo[curr] > 0) {
            return memo[curr];
        }
        
        memo[curr] = climbStairs(curr + 1, dest, memo) + climbStairs(curr + 2, dest, memo);
        
        return memo[curr];
    }
}