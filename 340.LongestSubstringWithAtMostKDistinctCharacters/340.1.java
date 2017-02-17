/*
The main idea is to maintain a sliding window with 2 unique characters. 
The key is to store the last occurrence of each character as the value in the hashmap. 
This way, whenever the size of the hashmap exceeds 2, we can traverse through the map 
to find the character with the left most index, and remove 1 character from our map. 
Since the range of characters is constrained, we should be able to find the left most index in constant time.

时间: O(kN)
每个元素最多进窗口一次，最多出窗口一次(remove操作O(k))
*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        int right = 0, maxLen = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length()) {
                char ch = s.charAt(right);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    } else {
                        map.put(ch, 1);
                    }
                }
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left);
            char leftChar = s.charAt(left);
            if (map.get(leftChar) > 1) {
                map.put(leftChar, map.get(leftChar) - 1);
            } else {
                map.remove(leftChar);
            }
        }
        
        return maxLen;
    }
}