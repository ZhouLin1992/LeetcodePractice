public class Solution {
    public String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		int[] res = new int[len1 + len2];

		for (int i = len1 - 1; i >= 0; i--) {
			int carry = 0;
			for (int j = len2 - 1; j >= 0; j--) {
				res[i + j + 1] += carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				carry = res[i + j + 1] / 10;
				res[i + j + 1] %= 10;
			}
			res[i] = carry;
		}

		StringBuilder sb = new StringBuilder();
		for (int num: res) 
			sb.append(num);
		while (sb.length() != 0 && sb.charAt(0) == '0') 
			sb.deleteCharAt(0);
		return sb.length() == 0 ? "0" : sb.toString();

		// For displaying the result: Method
        // int i = 0;
        // while (i < res.length && res[i] == 0) i++;
        // if (i >= res.length) return "0";
        // StringBuilder sb = new StringBuilder();
        // for (; i < res.length; i++) sb.append(res[i]);
        // return sb.toString();

    }
}