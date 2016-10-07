public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();

		HashMap<Character, Integer> hm = new HashMap<>();
		int len = 0, start = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (hm.containsKey(ch)) 
				start = Math.max(start, hm.get(ch) + 1);
			hm.put(ch, i);
			len = Math.max(len, i - start + 1);
		}
		return len;		       
    }
}