/*
用一个哈希表记录目标字符串每个字母的个数，一个哈希表记录窗口中每个字母的个数。
先找到第一个有效的窗口，用两个指针标出它的上界和下界。然后每次窗口右界向右移时，
将左边尽可能的右缩，右缩的条件是窗口中字母的个数不小于目标字符串中字母的个数。

时间：O(N)
空间：O(1)
*/


public class Solution {
    public String minWindow(String s, String t) {
        // 用于记录窗口内每个字母出现次数
        int[] srcHash = new int[256];
        int[] tgtHash = new int[256];
        
        // 记录目标字符串每个字母出现次数
        for (int i = 0; i < t.length(); i++) {
            tgtHash[t.charAt(i)]++;
        }
        
        int found = 0, start = -1, end = s.length() - 1;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < s.length(); right++) {
            // 每来一个字符给它的出现次数加1
            char rightChar = s.charAt(right);
            srcHash[rightChar]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if (srcHash[rightChar] <= tgtHash[rightChar]) {
                found++;
            }
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if (found == t.length()) {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while (left < right && srcHash[s.charAt(left)] > tgtHash[s.charAt(left)]) {
                    srcHash[s.charAt(left)]--;
                    left++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                srcHash[s.charAt(left)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                left++;
            }
        }
        
        // 如果begin没有修改过，返回空
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}