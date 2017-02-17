/*
例子：S = “eceba”, result is "ece", lenght is 3
这道题给我们一个字符串，让我们求最多有两个不同字符的最长子串。那么我们首先想到的是用哈希表来做，
哈希表记录每个字符的出现次数，然后如果哈希表中的映射数量超过两个的时候，我们需要删掉一个映射，
比如此时哈希表中e有2个，c有1个，此时把b也存入了哈希表，那么就有三对映射了，这时我们的left是0，
先从e开始，映射值减1，此时e还有1个，不删除，left自增1。这是哈希表里还有三对映射，此时left是1，
那么到c了，映射值减1，此时c映射为0，将c从哈希表中删除，left自增1，然后我们更新结果为i - left + 1，
以此类推直至遍历完整个字符串

时间：
O(2N)
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int left = 0, maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}