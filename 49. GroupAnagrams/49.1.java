public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
		    List<List<String>> res = new ArrayList<>();
		    List<String> list = new ArrayList<>();
		    res.add(list);
			return res;
		}

		// Arrays.sort(strs);

		Map<String, List<String>> map = new HashMap<>();
		for (String str: strs) {
			char[] strChar = str.toCharArray();
			Arrays.sort(strChar);
			String tmp = String.valueOf(strChar);
			if (!map.containsKey(tmp)) {
				map.put(tmp, new ArrayList<String>());
			}
			map.get(tmp).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}
}