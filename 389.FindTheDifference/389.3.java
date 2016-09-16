public class Solution {
    public char findTheDifference(String s, String t) {
    	int c = 0;

    	for (int i = 0; i < s.length(); i++)
    		c ^= s.charAt(i);

    	for (int j = 0; j < t.length(); j++)
    		c ^= t.charAt(j);

    	return (char)c;	
    }
}