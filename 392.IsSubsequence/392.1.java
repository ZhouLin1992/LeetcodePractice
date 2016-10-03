public class Solution {
    public boolean isSubsequence(String s, String t) {
		if (s == null || t == null) return false;
		int sc = 0, tc = 0;
		while (sc < s.length() && tc < t.length()) {
			while (tc < t.length() && s.charAt(sc) != t.charAt(tc)) tc++;
			tc++;
			sc++;
		}
		if (sc != s.length()) return false;
		return true;        
    }
}