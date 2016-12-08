// O(N) time and O(N) space
// Through hash function, transform anagram to hash function key
// hash function key is like "a1b1z1"
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		// if null or length = 0
		if (strs == null || strs.length == 0) {
		    List<List<String>> res = new ArrayList<>();
		    List<String> list = new ArrayList<>();
		    res.add(list);
			return res;
		} 

		// Map:
		// key: anagram after hash function
		// value: anagrams with the same characters set
		Map<String, List<String>> map = new HashMap<>();
		for (String str: strs) {
			String hash = getHash(str);
			if (!map.containsKey(hash)) {
				map.put(hash, new ArrayList<String>());
			}
			map.get(hash).add(str);
		}

		// return all the map values
		return new ArrayList<List<String>>(map.values());
	}

	// get the self-define hash function for map
	private String getHash(String str) {
		char[] strChar = new char[26];
		for (int i = 0; i < str.length(); i++) {
			strChar[str.charAt(i) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			char add = (char)('a' + i);
			sb.append(add);
			sb.append(strChar[i]);
		}

		return sb.toString();
	}
}