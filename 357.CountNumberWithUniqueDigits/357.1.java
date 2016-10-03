public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		if (n == 1) return 10;
		if (n > 10) return 0;

		int sum = 10;
		int tmp = 9, digit = 9;
		while (n >= 2) {
			tmp *= digit;
			digit--;
			n--;
			sum += tmp;
		}
		return sum;        
    }
}