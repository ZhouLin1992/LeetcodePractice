// 汇总帖 https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int counter = map.size();
        int start = 0;
        int end = 0;
        int len = p.length();
        
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
                
                if (end - start == len) {
                    result.add(start);
                }
                
                start++;
            }
        }
        
        return result;
    }
}