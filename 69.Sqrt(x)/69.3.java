public class Solution {
	public int mySqrt(int x) {
		if (x <= 1) return x;

		long t = x;
		while (t * t > x) 
			t = (t + x / t) / 2;
		return (int)t;		
	}
}