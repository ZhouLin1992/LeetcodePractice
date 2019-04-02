class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // regex "\\W+": 匹配非字母、数字、下划线。等价于 '[^A-Za-z0-9_]'
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
        	if (!set.contains(word)) {
        		map.put(word, map.getOrDefault(word, 0) + 1);
        	}
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}