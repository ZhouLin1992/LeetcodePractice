public class Solution {
    public boolean isSubsequence(String s, String t) {
		if (t.length() < s.length()) return false;

		for (int indexS = 0, prev = 0; indexS < s.length(); indexS++, prev++) {
			char ch = s.charAt(indexS);
			prev = t.indexOf(ch, prev);
			if (prev == -1) return false;
		}
		return true;    
    }
}