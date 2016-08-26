public class Solution {
    public String reverseString(String s) {
		if (s == null)
			return null;
		if (s == "")
			return "";
		StringBuilder str = new StringBuilder(s);
		int start = 0, end = str.length() - 1;
		while (start < end) {
			char firstValue = str.charAt(start);
			str.setCharAt(start, str.charAt(end));
			str.setCharAt(end, firstValue);
			start++;
			end--;
		}
		return str.toString();
    }
}