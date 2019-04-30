class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.length() == 0 || shifts == null || shifts.length == 0) {
            return S;
        }
        
        char[] result = S.toCharArray();
        int shift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift = (shifts[i] + shift) % 26;
            result[i] = (char)((result[i] - 'a' + shift) % 26 + 'a');
        }
        
        return String.valueOf(result);
    }
}