public class Solution {
    public char findTheDifference(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();

		Arrays.sort(sc);
		Arrays.sort(tc);

		for (int i = 0; i < s.length(); i++) 
			if (sc[i] != tc[i])
				return tc[i];
		
		return tc[t.length() - 1];	
    }
}