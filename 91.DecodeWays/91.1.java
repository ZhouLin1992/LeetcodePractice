/*
Recursive
time: o(n)
spce: o(n)

https://www.youtube.com/watch?v=YcJTyrG3bZs&feature=youtu.be
https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/decodeWays.java
*/

class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        numDecodings(memo, 0, s);
        return memo[0];
    }
    
    private int numDecodings(int[] memo, int start, String s) {
        if (start >= s.length()) {
            return 1;
        }
        
        if (memo[start] > -1) {
            return memo[start];
        }
        
        int sum = 0;
        if (start + 1 <= s.length()) {
            if (isValid(s.substring(start, start + 1))) {
                sum += numDecodings(memo, start + 1, s);
            }
        }
        
        if (start + 2 <= s.length()) {
            if (isValid(s.substring(start, start + 2))) {
                sum += numDecodings(memo, start + 2, s);
            }
        }
        
        memo[start] = sum;
        return sum;
    }
    
    private boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        
        if (s.charAt(0) == '0') {
            return false;
        }
        
        return 1 <= Integer.valueOf(s) && Integer.valueOf(s) <= 26;
    }
}