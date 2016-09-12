public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() == 0 && t.length() == 0) return true;
		
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		char[] s1 = new char[256];
		char[] s2 = new char[256];

		for (int i = 0; i < s.length(); i++) {
			char sl = sChar[i];
			char tl = tChar[i];
			if (s1[(int)sl] == 0 && s2[(int)tl] == 0) {
				s1[(int)sl] = tl;
				s2[(int)tl] = sl;
			} else {
				if (s1[(int)sl] != tl || s2[(int)tl] != sl)
					return false;
			}
		}
		return true;
	}
}