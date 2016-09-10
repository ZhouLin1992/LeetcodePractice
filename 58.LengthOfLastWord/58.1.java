public class Solution {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) return 0;
		String[] strings = s.split(" ");
		return strings[string.length - 1].length();
	}
}