class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int len = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int counter = 0;
        
        while (end < s.length()) {
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (map.get(curr) > 1) {
                counter++;
            }
            end++;
            
            while (counter > 0) {
                char temp = s.charAt(start);
                if (map.get(temp) > 1) {
                    counter--;
                }
                map.put(temp, map.getOrDefault(temp, 0) - 1);
                start++;
            }
            
            len = Math.max(len, end - start);
        }
        
        return len;
    }
}