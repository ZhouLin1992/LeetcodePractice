/**
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1240-tiling-a-rectangle-with-the-fewest-squares/
https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/discuss/414260/8ms-Memorized-Backtrack-Solution-without-special-case!
**/


class Solution {
    private int max = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        dfs(n, m, new int[n + 1], 0);
        return max;
    }
    
    private void dfs(int n, int m, int[] height, int count) {
        if (count > max) {
            return;
        }
        boolean isFull = true;
        int minH = Integer.MAX_VALUE;
        int pos = -1;

        for (int i = 1; i <= n; i++) {
            if (height[i] < m) {
                isFull = false;
            }
            if (height[i] < minH) {
                pos = i;
                minH = height[i];
            }
        }
        
        if (isFull) {
            max = Math.min(max, count);
            return;
        }
        
        int end = pos;
        while (end + 1 <= n && height[end + 1] == height[pos] && end + 1 - pos + 1 + minH <= m) {
            end++;
        }
        for (int j = end; j >= pos; j--) {
            int diff = j - pos + 1;
            
            int[] next = Arrays.copyOf(height, n + 1);
            for (int k = pos; k <= j; k++) {
                next[k] += diff;
            }
            dfs(n, m, next, count + 1);
        }
    }
}