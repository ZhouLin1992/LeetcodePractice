public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x / 10 == 0)) return false;
		int reverse = 0;
		while (x > reverse) {
		reverse = reverse * 10 + x % 10;
		x /= 10;
		}
		if (reverse / 10 == x || reverse == x) return true;
		else return false;
	}
}