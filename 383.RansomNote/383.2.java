public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() == 0 && magazine.length() == 0) return true;
		if (ransomNote.length() != 0 && magazine.length() == 0) return false;

		char[] r = ransomNote.toCharArray();
		char[] m = ransomNote.toCharArray();

		int[] count = new int[26];

		for (char ch: m)
			count[ch - 'a']++;

		for (char ch: r)
			if (count[ch - 'a'] > 0)
				count[ch - 'a']--;
			else 
				return false;

		return true;
	}
}