class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        int level = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> set = new HashSet<>();
            for (String str : beginSet) {
                char[] chs = str.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[i] = ch;
                        String next = new String(chs);
                        
                        if (endSet.contains(next)) {
                            return level + 1;
                        }
                        
                        if (!visited.contains(next) && dict.contains(next)) {
                            visited.add(next);
                            set.add(next);
                        }
                    }
                    chs[i] = old;
                }
            }
            
            level++;
            beginSet = set;
        }
        
        return 0;
    }
}