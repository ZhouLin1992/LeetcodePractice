class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new LinkedList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                return s1.compareTo(s2);
            }            
        });
        Set<String> dicts = new HashSet<>();

        for (String word : words) {
            if (canForm(word, dicts)) {
                result.add(word);
            }
            dicts.add(word);
        }
        
        return result;
    }
    
    private boolean canForm(String word, Set<String> dicts) {
        if (dicts.isEmpty()) {
            return false;
        }

        int len = word.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dicts.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}