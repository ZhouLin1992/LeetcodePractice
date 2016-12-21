public class Solution {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] stringArr = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(stringArr));
        // String.join(delimiter, elements), elements can be arrays or list
        return String.join(" ", stringArr);
	}
}