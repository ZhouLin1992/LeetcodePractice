public class Solution {
	public int mySqrt(int x) {
		long res = 0;
		long bit = (1l << 16);
		while (bit > 0) {
			res |= bit;
			if (res * res > x) {
				res ^= bit;			    
			}
			bit >>= 1;
		}
		return (int)res;		
	}
}