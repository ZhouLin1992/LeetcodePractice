public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		if (n > 10) return 0;

		int tmp = 9, sum = 1, digit = 9;
		while (n > 0) {
			sum += tmp;
			tmp *= digit--;
			n--;
		}
		return sum;       
    }
}