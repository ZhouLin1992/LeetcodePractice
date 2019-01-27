/*
Binary search
time: O(m*n*logn), log(n) iterations
space: O(1)
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        int low = 0;
        int high = minLen;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        if (isCommonPrefix(strs, high)) {
            return strs[0].substring(0, high);
        }
        return strs[0].substring(0, low);
    }
    
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}