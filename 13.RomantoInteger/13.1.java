public class Solution {
	public int romanToInt(String s) {
		int result = 0, digit = 0, prev = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.toUpperCase().charAt(i)) {
			    case 'I': digit = 1; break;
				case 'V': digit = 5; break;
				case 'X': digit = 10; break;
				case 'L': digit = 50; break;
				case 'C': digit = 100; break;
				case 'D': digit = 500; break;
				case 'M': digit = 1000; break;
			}
			if (digit >= prev) {result += digit;}
			else {result -= digit;}
			prev = digit;
		}
		return result;
	}
}