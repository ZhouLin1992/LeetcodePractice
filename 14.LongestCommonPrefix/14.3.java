/*
Divide & conquer
time: worse: T(S)=2*T(S/2)+O(m) => T(S) (S=m*n)
best: O(minLen*n)
space: O(m*logn), log(n) recursive calls
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String leftPre = longestCommonPrefix(strs, l, mid);
            String rightPre = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(leftPre, rightPre);
        }
    }
    
    private String commonPrefix(String leftPre, String rightPre) {
        int min = Math.min(leftPre.length(), rightPre.length());
        for (int i = 0; i < min; i++) {
            if (leftPre.charAt(i) != rightPre.charAt(i)) {
                return leftPre.substring(0, i);
            }
        }
        
        return leftPre.substring(0, min);
    }
}