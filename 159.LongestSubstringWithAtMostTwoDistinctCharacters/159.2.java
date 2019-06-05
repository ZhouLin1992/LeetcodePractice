class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int len = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) {
                count++;
            }
            end++;
            
            while (count > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    count--;
                }
                start++;
            }
            
            len = Math.max(len, end - start);
        }
        return len;
    }
}