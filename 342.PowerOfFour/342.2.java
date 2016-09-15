public class Solution {
	public boolean isPowerOfFour(int num) {
        if (num == 1) return true;
        if (num <= 0) return false;
		return (num % 4 == 0) ? isPowerOfFour(num / 4) : false;
		// return (int)Math.pow(4, (int)(Math.log(Integer.MAX_VALUE) / Math.log(4))) % 4 == 0;
	}
}