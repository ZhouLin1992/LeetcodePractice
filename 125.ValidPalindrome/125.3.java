public class Solution {
	public boolean isPalindrome(String s) {
		if(s.length() == 0) return true;
		s = s.trim();
		int start = 0, end = s.length() - 1;
		while (start < end) {
			while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
			while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
			if (!isPalindrome(s.charAt(start), s.charAt(end))) return false;
			start++;
			end--;
		}

	}

	public boolean isPalindrome(char ch1, char ch2) {
		if (ch1 >= '0' && ch1 <='9' || ch2 >='0' && ch2 <= '9') return ch1 == ch2;
		return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
	}
}