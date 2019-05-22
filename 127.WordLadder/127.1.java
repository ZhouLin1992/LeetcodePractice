class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        int level = 1;
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String curr = queue.poll();
                char[] chs = curr.toCharArray();

                for (int i = 0; i < curr.length(); i++) {
                    char oldChar = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[i] = ch;
                        String next = new String(chs);

                        if (next.equals(endWord)) {
                            return level + 1;
                        }

                        if (dict.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    chs[i] = oldChar;
                }
            }
            level++;
        }
        return 0;
    }
}