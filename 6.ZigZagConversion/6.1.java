public class Solution {
	public String convert(String s, int numRows) {
        if (numRows == 1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuilder("");
		}
		int incre = 1;
		int index = 0;
		int line = 0;
		while (index < s.length()) {
			if (line == 0) incre = 1;
			if (line == numRows - 1) incre = -1;
			sb[line].append(s.charAt(index++));
			line += incre;
		}
		String str = "";
		for (int i = 0; i < numRows; i++) {
			str += sb[i].toString();
		}
		return str;
	}
}