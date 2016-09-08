public class Solution {
	public boolean isPowerOfTwo(int n) {
		return (n > 0 && (int)(Math.pow(2, 30)) % n == 0);
	}
}