// need to deal with negative and exceed boundary (Integer.MIN_VALUE)
// binary search

public class Solution {
    public double myPow(double x, int n) {
        // corner case
        if (x == 0) {
            return 0;
        }
        
        // base case
        if (n == 0) {
            return 1;
        }
        
        // corner case: when n == Integer.MIN_VALUE
        if (n < 0) {
            double res = x * myPow(x, -(n + 1));
            return 1 / res;
        }
        
        // recursive body
        double res = myPow(x, n / 2);
        res = res * res;
        
        // when n is odd
        if (n % 2 == 1) {
            res = x * res;
        }
        
        return res;
    }
}