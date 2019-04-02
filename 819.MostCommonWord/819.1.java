class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");
		Set<String> set = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			if (!set.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}

		String result = null;
		int count = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (result == null || entry.getValue() > map.get(result)) {
				result = entry.getKey();
			}
		}

		return result;
    }
}