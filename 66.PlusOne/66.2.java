class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        
        // If you never return at the first return statement, then that means the digits array had all 9s (ex. [9,9,9]) 
        // in this case he simply creates a new array with one extra index and sets the first index to 1 and the rest 
        // are default initialized to zero
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        
        // Newnumber only work for one scenario, e.g.: 9999->10000
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}