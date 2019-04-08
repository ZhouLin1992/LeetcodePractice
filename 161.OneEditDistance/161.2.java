class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        if (lenS > lenT) {
            return isOneEditDistance(t, s);
        }
        
        for (int i = 0; i < lenS; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (lenS == lenT) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        return Math.abs(lenS - lenT) == 1;
    }
}