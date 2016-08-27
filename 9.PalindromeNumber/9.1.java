public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
        if (x >= 0 && x < 10) return true;
        int tail = 0, reverse = 0, init = x;
		while (init >= 10) {
			tail = init % 10;
			reverse = reverse * 10 + tail;
			init /= 10;
		}
		if (reverse == x / 10 && init == x % 10) return true;
		else return false;
	}
}