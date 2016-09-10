public class Solution {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) return 0;
		int i = s.length(), sum = 0;
		while (s.charAt(i--) != ' ') sum++;
		return sum;
	}
}