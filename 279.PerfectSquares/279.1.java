// DP: O(N * sqrt(N)) time, O(N) space

public class Solution {
    public int numSquares(int n) {
        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (j * j <= i) {
                min = Math.min(min, cnt[i - j * j] + 1);
                j++;
            }
            cnt[i] = min;
        }
        return cnt[n];
    }
}