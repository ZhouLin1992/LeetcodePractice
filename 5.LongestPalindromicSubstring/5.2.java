// O(N^2) time, O(1) space
// A palindrome mirrors around its center, so it can expand from its center
// there are 2N-1 centers (N odd centers and N - 1 even centers)


public class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int len = s.length();
		if (len == 1) {
			return s;
		}

		int max = 0, low = 0;
		for (int i = 0; i < len; i++) {
			// the longest length is odd
			int len1 = getLen(s, i, i);
			// the longest length is even
			int len2 = getLen(s, i, i + 1);
			if (max < Math.max(len1, len2)) {
				low = len1 > len2 ? (i - len1 / 2) : (i - len2 / 2 + 1);
				max = Math.max(len1, len2);
			}
		}

		return s.substring(low, low + max);
	}

	private int getLen(String s, int low, int high) {
		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}
		return high - low - 2 + 1;
	}
}