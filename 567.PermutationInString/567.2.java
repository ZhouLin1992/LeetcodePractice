class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 == 0 || len2 == 0) {
            return false;
        }
        
        int sum = len1;
        int[] count = new int[26];
        
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        
        for (int l = 0, r = 0; r < len2; r++) {
            char ch = s2.charAt(r);
            int index = ch - 'a';
            
            if (count[index] > 0) {
                sum--;
                count[index]--;
                //check for permutation match.
                if (sum == 0) {
                    return true;
                }
            } else {
                // if there is enough number for char c or c is never seen before.
                // we move left pointer next to the position where we first saw char c 
                // or to the r+1(we never see char c before), 
                //and during this process we restore the map.
                while (l <= r && s2.charAt(l) != s2.charAt(r)) {
                    count[s2.charAt(l) - 'a']++;
                    l++;
                    sum++;
                }
                l++;
            }
        }
        
        return false;
    }
}