public class Solution {
	public int lengthOfLastWord() {
		return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
	}
}