public class Solution {
	pubic int myAtoi(String str) {
		if (str.length() == 0 || str == null) return 0;
		str = str.trim();
		int mark = 1, i = 0, result = 0, digit;
		if (str.charAt(i) == '+' || str.charAt(i) == '-')
			mark = str.charAt(i++) == '+' ? 1 : -1;
		for (; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return mark * result;
			else {
				digit = Character.getNumericValue(str.charAt(i));
				if (result > Integer.MAX_VALUE / 10 || 
					mark == 1 && result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10 ||
					mark == -1 && result == Math.abs(Integer.MIN_VALUE / 10) && digit > Math.abs(Integer.MAX_VALUE % 10))
					return mark == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				else result = result * 10 + digit;
			}
		}
		return mark * result;
	}
}