// O(N^2) time, O(N^2) space

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        if (s.length() == 1) {
            return s;
        }
        
        int len = s.length();
        int[] res = new int[2];
        int longest = 0;
        boolean[][] matrix = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && ((right - left <= 2) || matrix[left + 1][right - 1])) {
                    matrix[left][right] = true;
                    if (longest < right - left + 1) {
                        res[0] = left;
                        res[1] = right;
                        longest = right - left + 1;
                    }
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }
}