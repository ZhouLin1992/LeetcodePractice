public class Solution {
	public int reverse(int x) {
		int result = 0;
		int lastResult = 0;
		int tail;
		while (x != 0) {
			tail = x % 10;
			result = result * 10 + tail;
			if ((result - tail) / 10 != lastResult) {
				return 0;
			}
			lastResult = result;
			x /= 10;
		}
		return result;
	}
}