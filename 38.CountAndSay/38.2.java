public class Solution {
	public String countAndSay(int n) {
		if (n == 1) return "" + 1;
		String str;
		StringBuilder sb = new StringBuilder("" + 1);
		int count = 1;
		for (int j = 2; j <= n; j++) {
			str = sb.toString();
			count = 1;
			sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
					count++;
					i++;
				}
				sb.append(count).append(str.charAt(i));
				count = 1;
			}
		}
		return sb.toString();
	}
}