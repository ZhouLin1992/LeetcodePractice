public class Solution {
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (strs.length != pattern.length()) return false;
		char[] pArr = pattern.toCharArray();
		HashMap hm = new HashMap();
		for (Integer i = 0; i < pattern.length(); i++) {
			if (hm.put(pArr[i], i) != hm.put(strs[i], i)) return false;
		}
		return true;
	}
}