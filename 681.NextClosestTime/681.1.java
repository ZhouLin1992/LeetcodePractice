class Solution {
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[]{result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);
        
        // find next digit for HH:M_
        // no upper limit
        result[4] = findNext(result[4], (char)('9' + 1), digits);
        if (result[4] > time.charAt(4)) {
            return new String(result);
        }
        
        // find next digit for HH:_M
        result[3] = findNext(result[3], '5', digits);
        if (result[3] > time.charAt(3)) {
            return new String(result);
        }
        
        // find next digit for H_:MM
        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char)('9' + 1), digits);
        if (result[1] > time.charAt(1)) {
            return new String(result);
        }
        
        // find next digit for _H:MM
        result[0] = findNext(result[0], '2', digits);
        return new String(result);
    }
    
    private char findNext(char curr, char max, char[] digits) {
        if (curr == max) {
            return digits[0];
        }
        
        int pos = Arrays.binarySearch(digits, curr) + 1;
        while (pos < 4 && (curr == digits[pos] || digits[pos] > max)) {
            pos++;
        }
        
        return pos == 4 ? digits[0] : digits[pos];
    }
}