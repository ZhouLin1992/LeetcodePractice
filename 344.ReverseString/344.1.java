public class Solution {
    public String reverseString(String s) {
        if (s == null) 
			return null;
		if (s == "")
			return "";
		StringBuilder str = new StringBuilder(s);
		return str.reverse().toString();
    }
}