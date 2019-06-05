class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> cur = new HashMap<>();
        int wordLen = words[0].length();
        int count;
        int start;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            count = 0;
            start = i;
            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String str = s.substring(j, j + wordLen);
                if (map.containsKey(str)) {
                    cur.put(str, cur.getOrDefault(str, 0) + 1);
                    
                    if (cur.get(str) <= map.get(str)) {
                        count++;
                    }
                    
                    while (cur.get(str) > map.get(str)) {
                        String tmp = s.substring(start, start + wordLen);
                        cur.put(tmp, cur.get(tmp) - 1);
                        start += wordLen;
                        
                        if (cur.get(tmp) < map.get(tmp)) {
                            count--;
                        }
                    }
                    
                    if (count == words.length) {
                        String tmp = s.substring(start, start + wordLen);
                        cur.put(tmp, cur.get(tmp) - 1);
                        result.add(start);
                        start += wordLen;
                        count--;
                    }
                } else {
                    cur.clear();
                    count = 0;
                    start = j + wordLen;
                }             
            }
            cur.clear();
        }
        return result;
    }
}