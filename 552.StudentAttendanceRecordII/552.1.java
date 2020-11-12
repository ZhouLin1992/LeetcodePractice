class Solution {
    private int mod = 1000000007;

    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        
        return helper(n, 0, 0, new Integer[n + 1][2][3]);
    }
    
    private int helper(int n, int totalA, int continuousL, Integer[][][] cache) {
        if (n == 0) {
            return 1;
        }
        if (cache[n][totalA][continuousL] != null) {
            return cache[n][totalA][continuousL];
        }
        
        int result = 0;
        
        // choose 'A', can reset L counts here
        if (totalA == 0) {
            result += helper(n - 1, totalA + 1, 0, cache);
            result %= mod;
        }
        
        // choose 'L'
        if (continuousL < 2) {
            result += helper(n - 1, totalA, continuousL + 1, cache);
            result %= mod;
        }
        
        // choose 'P', can reset L counts here
        result += helper(n - 1, totalA, 0, cache);
        result %= mod;
        cache[n][totalA][continuousL] = result;
        return result;
    }
}