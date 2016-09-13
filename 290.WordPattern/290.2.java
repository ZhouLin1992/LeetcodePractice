public class Solution {
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) return false;
		char[] pArr = pattern.toCharArray();
		HashMap<Character, String> hm1 = new HashMap<>();
		HashMap<String, Character> hm2 = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			if (hm1.containsKey(pArr[i]) && hm2.containsKey(strs[i])) {
				if (hm1.get(pArr[i]).equals(strs[i]) && hm2.get(strs[i]) == pArr[i]) continue;
				else return false;
			} else if (!hm1.containsKey(pArr[i]) && !hm2.containsKey(strs[i])) {
				hm1.put(pArr[i], strs[i]);
				hm2.put(strs[i], pArr[i]);
			} else return false;
		} 
		return true;
	}
}