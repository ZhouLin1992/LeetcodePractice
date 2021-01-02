// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/discuss/369094/Java-100-Solution-(

class Solution {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        while (k > 1) {
            long gap = findGap(cur, cur + 1, n);
            if (gap < k) {
                k -= gap;
                cur += 1;
            } else {
                k -= 1;
                cur *= 10;
            }
        }
        return (int)cur;
    }
    
    private long findGap(long a, long b, int n) {
        long gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}