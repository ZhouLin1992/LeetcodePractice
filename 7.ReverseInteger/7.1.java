public class Solution {
	public int reverse(int x) {
		StringBuilder sb = new StringBuilder(new Long(Math.abs((long)x)).toString());
		long result = Long.parseLong(sb.reverse().toString());
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
		if (x < 0) return (int)(0 - result);
		return (int)result;
	}
}