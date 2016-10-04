public class Solution {
    public int maxProduct(String[] words) {
		if (words.length == 0 || words == null) return 0;

		int len = words.length;
		int[] values = new int[len];
		for (int i = 0; i < len; i++) {
			String tmp = words[i];
			for (int j = 0; j < tmp.length(); j++) 
				values[i] |= 1 << (tmp.charAt(j) - 'a');
		}

		int max = 0;
		for (int j = 0; j < len; j++) {
			for (int k = j + 1; k < len; k++) 
				if ((values[j] & values[k]) == 0 && words[j].length() * words[k].length() > max)
					max = words[j].length() * words[k].length();
		}
		return max;        
    }
}