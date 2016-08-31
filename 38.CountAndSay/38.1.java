public class Solution {
    public String countAndSay(int n) {
		if (n == 1) return Integer.toString(1);
		String result = "" + 1,
			   prev = result;
		int count = 1;
		for (int i = 2; i <= n; i++) {
			prev = result;
			count = 1;
			result = "";
			for (int j = 1; j < prev.length(); j++) {
				if (prev.charAt(j) != prev.charAt(j - 1)) {
					result = result + count + prev.charAt(j - 1);
					count = 1;
				} else count++;
			}
			result = result + count + prev.charAt(prev.length() - 1);
		}
		return result;
    }
}