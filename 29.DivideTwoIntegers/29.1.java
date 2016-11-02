public class Solution {
    public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;

		if (divisor == 0)
			return dividend < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

		if (dividend == Integer.MIN_VALUE && divisor == -1)
		return Integer.MAX_VALUE;

		// one method for negative or not:
		// boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		boolean neg = (dividend < 0) ^ (divisor < 0);

		// in case dividend is MIN_VALUE
		long did = Math.abs((long)dividend);
		long div = Math.abs((long)divisor);
		int res = 0;

		while (did >= div) {
			int shift = 0;
			while (did >= (div << shift)) {
				shift++;
			}
			did -= div << (shift - 1);
			res += ((long)1 << (shift - 1));
		}
	    // one method for 取反：return neg == true ? (-1) * res : res;
		return neg == true ? (~res + 1) : res;        
    }
}