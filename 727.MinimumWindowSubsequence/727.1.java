/**
Use normal two pointers to find the matched substring, for each matched substring, 
we start from the end and find the minimum substring derivative from this substring
**/

class Solution {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0 || S.length() < T.length()) {
            return "";
        }
        
        int sLen = S.length();
        int tLen = T.length();
        int tIdx = 0;
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        
        while (i < sLen) {
            if (S.charAt(i) == T.charAt(tIdx)) {
                tIdx++;
                // all characters in T are matched
                if (tIdx == tLen) {
                    int end = i + 1;
                    tIdx--;
                    // both i and tIdx starts to traverse back to find the minimum length
                    while (tIdx >= 0) {
                        if (S.charAt(i) == T.charAt(tIdx)) {
                            tIdx--;
                        }
                        i--;
                    }
                    // the first match index in S
                    i++;
                    // reset tIdx==0
                    tIdx++;
                    if (end - i < minLen) {
                        minLen = end - i;
                        res = S.substring(i, end);
                    }
                }
            }
            // after we find one possible substring, we want to reset and start traverse from the next one from the left
            // S is "abdacbc" and T is "abc"
            i++;
        }
        
        return res;
    }
}