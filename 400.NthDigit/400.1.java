public class Solution {
    public int findNthDigit(int n) {
		int len = 1;
		long mark = 9;
		int start = 1;

		while (n > len * mark) {
			n -= len * mark;
			len++;
			mark *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		StringBuilder sb = new StringBuilder(start + "");
		return Character.getNumericValue(sb.charAt((n - 1) % len));    
    }
}