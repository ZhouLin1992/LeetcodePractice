class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = "";
        
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                result = word.length() > result.length() ? word : result;
                set.add(word);
            }
        }
        
        return result;
    }
}