public class Solution {
    public String convertToTitle(int n) {
		String str = "";
		while (n > 0) {
			str = (char)('A' + (n - 1) % 26) + str;
			n = (n - 1) / 26;
		}
		return str;
    }
}