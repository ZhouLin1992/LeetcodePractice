class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }

        int len = bits.length;
        int i = 0;
        
        while (i < len - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }

        return i == len - 1;
    }
}