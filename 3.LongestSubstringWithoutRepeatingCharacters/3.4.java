public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();

		int[] arr = new int[128];
		char[] str = s.toCharArray();
		int len = 0, start = 0, max = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = str[i];
			if (arr[ch] == 0) {
				// first time appears
				arr[ch] = i + 1; // mark the position
				len++; // length
				max = Math.max(len, max);
			} else {
				// real index of prev appearence of current char
				int end = arr[ch] - 1; 
				//mark previous letters as never appear
				for (int j = start; j < end; j++) 
					arr[str[j]] = 0;
				start = end + 1;
				arr[ch] = i + 1;
				len = i - end;
			}
		}
		return max;
	}
}