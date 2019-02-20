/*
// https://leetcode.windliang.cc/leetCode-44-Wildcard-Matching.html
// https://leetcode.com/problems/wildcard-matching/discuss/17810/Linear-runtime-and-constant-space-solution

time: o(n^2), worse case
space: o(1)

worse case:
s = "aa...a"
p = "*aaab"
*/

class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        
        // pointer for String s
        int sp = 0;
        // pointer for String p
        int pp = 0;
        int starIndex = -1;
        int match = -1;
        
        while (sp < lenS) {
            if (pp < lenP && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            // assume '*' matches zero occurence 
            } else if (pp < lenP && p.charAt(pp) == '*') {
                starIndex = pp;
                match = sp;
                pp++;
            /*
            if characters do not match,
            try to match '*' with a character in String s
            */
            } else if (starIndex != -1) {
                pp = starIndex + 1;
                match++;
                sp = match;
            // characters do not match and there is no '*' in the pattern so far
            } else {
                return false;
            }
        }
        
        while (pp < lenP && p.charAt(pp) == '*') {
            pp++;
        }
        
        return pp == p.length();
    }
}