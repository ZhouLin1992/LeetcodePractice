class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int counter = map.size();
        int len = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int head = -1;
        
        while (end < s.length()) {
            char curr = s.charAt(end);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    counter--;
                }
            }
            end++;
            
            while (counter == 0) {
                char temp = s.charAt(start);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) {
                        counter++;
                    }
                }
                
                if (end - start < len) {
                    len = end - start;
                    head = start;
                }
                
                start++;
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}