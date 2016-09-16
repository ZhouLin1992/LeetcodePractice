public class Solution {
    public char findTheDifference(String s, String t) {
		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) 
			count[s.charAt(i) - 'a']++;

		for (int j = 0; j < t.length(); j++) {
			count[t.charAt(j) - 'a']--;
			if (count[t.charAt(j) - 'a'] == -1)
				return t.charAt(j);		    
		}
		return (char)('a' - 1);		
    }
}