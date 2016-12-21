public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		String[] stringArr = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = stringArr.length - 1; i >= 0; i--) {
			// "" is not the same as " ";
			// after split, " " turns into " "
		    if (!stringArr[i].equals("")) {
			    sb.append(stringArr[i]).append(" ");		        
		    }
		}
        
        int len = sb.length();
        // left inclusive, right exclusive
        // remove the last " "
		return len == 0 ? "" : sb.substring(0, len - 1);
	}
}