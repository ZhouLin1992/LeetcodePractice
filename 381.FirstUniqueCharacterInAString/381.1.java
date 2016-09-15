public class Solution {
    public int firstUniqChar(String s) {
		if (s.length() == 1) return 0;
		if (s.length() == 0) return -1;

		// char[] ss = s.toCharArray();
		int[] count = new int[26];
		int[] index = new int[26];
		int first = -1;

		for (int i = 0; i < s.length(); i++) {
			int ind = s.charAt(i) - 'a';
			if (count[ind] == 0)
				index[ind] = i;
			count[ind]++;
		}

		for (int j = 0; j < 26; j++) {
			if (count[j] == 1)
				// if (first == -1)
				// 	first = index[j];
				// else 
				// 	if(index[j] < first)
				// 		first = index[j];
				first = first == -1 ? index[j]: Math.min(first, index[j]);
		}
		return first;
    }
}