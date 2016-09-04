public class Solution {
    public int titleToNumber(String s) {
		if (s.length() == 0) return 0;
		int sum = 0, len = s.length();
		for (int i = len - 1; i >= 0; i--) sum += (s.toUpperCase().charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
		return sum;
    }
}