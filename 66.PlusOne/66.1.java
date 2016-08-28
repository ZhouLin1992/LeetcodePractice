public class Solution {
    public int[] plusOne(int[] digits) {
		if (digits.length == 0 || digits == null) return new int[]{0};
		int sign = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9 && sign == 1) {
				digits[i] = 0;
			} else {
				digits[i] += sign;
				sign = 0;
			}
		}
		if (digits[0] == 0) {
			int[] newDigits = new int[digits.length + 1];
			for (int i = newDigits.length - 1; i > 0; i--) {
				newDigits[i] = digits[i - 1];
			}
			newDigits[0] = 1;
			digits = newDigits;
		}
		return digits;
    }
}