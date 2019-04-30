class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if (S == null || S.length() == 0 || shifts == null || shifts.length == 0) {
            return S;
        }
        
        char[] result = S.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = shifts.length - 1; i >= 0; i--) {
            result[i] = (char)((shifts[i] + result[i] - 'a') % 26 + 'a');
        }
        
        return String.valueOf(result);
    }
}