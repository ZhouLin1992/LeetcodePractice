/**
转换会发生多种情况：
1. link: a -> b -> c
2. cycle: a -> b -> c -> a 
In the above two cases, there should at least be one character 
that doesn't appear in both src/tgt strings, to use as tmp for
transformation; So we need to return if the size of set of 
unused characters < 26.
**/

class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0 || str1.length() != str2.length()) {
            return false;
        }
        
        if (str1.equals(str2)) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
        }
        
        return new HashSet<Character>(map.values()).size() < 26;
    }
}