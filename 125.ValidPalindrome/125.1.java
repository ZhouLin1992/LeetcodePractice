public class Solution {
	public boolean isPalindrome(String s) {
		if (s.length() == 0) return true;
		int start = 0, end = s.length() - 1;
		while (start < end) {
			while (start < end && !isAlphaNum(s.charAt(start))) start++;
			while (start < end && !isAlphaNum(s.charAt(end))) end--;
			if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) 
				return false;
			start++;
			end--;
		}
		return true;
	}

	private boolean isAlphaNum(char ch) {
		if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || Character.isDigit(ch)) return true;
		return false;
	}
}