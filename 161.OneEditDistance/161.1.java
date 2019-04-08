/*
 https://leetcode.com/problems/one-edit-distance/discuss/50098/My-CLEAR-JAVA-solution-with-explanation
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        if (Math.abs(lenS - lenT) >= 2) {
            return false;
        }
        
        for (int i = 0; i < Math.min(lenS, lenT); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // replace one character
                if (lenS == lenT) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                // t is longer than s, so the only possibility is deleting one char from t
                } else if (lenS < lenT) {
                    return s.substring(i).equals(t.substring(i + 1));
                // s is longer than t, so the only possibility is deleting one char from s
                } else if (lenS > lenT) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        
        return Math.abs(lenS - lenT) == 1;
    }
}