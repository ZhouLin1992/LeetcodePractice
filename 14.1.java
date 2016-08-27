public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prev = strs[strs.length - 1];
		String com = "";
		for (int i = strs.length - 2; i >= 0; i--) {
			if (prev.compareTo(strs[i]) >= 0) com = strs[i];
			prev = strs[i];
		}
		return com;
	}
}