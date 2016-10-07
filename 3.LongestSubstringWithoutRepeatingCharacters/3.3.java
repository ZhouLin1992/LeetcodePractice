public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();

		int slower = 0, faster = 0, len = 0;
		Set<Character> set = new HashSet<>();

		while (faster < s.length()) {
			if (set.add(s.charAt(faster))) {
				len = Math.max(len, set.size());
				faster++;
			} else 
				set.remove(s.charAt(slower++)); 
		}
		return len;      
    }
}