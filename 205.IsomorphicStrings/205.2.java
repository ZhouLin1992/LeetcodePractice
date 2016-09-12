public class Solution {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> hm1 = new HashMap<>();
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (hm1.containsKey(sArr[i])) {
				if (hm1.get(sArr[i]) == tArr[i]) continue;
				else return false;
			} else {
				if (!hm1.containsValue(tArr[i])) hm1.put(sArr[i], tArr[i]);
				else return false;
			}
		}
		return true;
	}
}