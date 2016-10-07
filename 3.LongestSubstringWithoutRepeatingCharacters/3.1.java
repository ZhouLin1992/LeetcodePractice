public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();

		int[] arr = new int[256];
		char[] str = s.toCharArray();
		int len = 0, start = 0;
		Arrays.fill(arr, -1);

		for (int i = 0; i < s.length(); i++) {
			char ch = str[i];
			if (arr[ch] != -1)
				start = Math.max(start, arr[ch] + 1);
			arr[ch] = i;
			len = Math.max(len, i - start + 1);
		}
		return len;	       
    }
}