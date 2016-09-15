public class Solution {
    public int firstUniqChar(String s) {
		if (s.length() == 1) return 0;
		if (s.length() == 0) return -1;

		int[] ind = new int[26];
		Arrays.fill(ind, -1);

		for (int i = 0; i < s.length(); i++) {
			int p = s.charAt(i) - 'a';
			if (ind[p] == -1)
				ind[p] = i;
			else 
				ind[p] = s.length();
		}

		int first = -1;
		for (int index: ind)
			if (index != -1 && index != s.length())
				first = first != -1 ? Math.min(first, index) : index;

		return first;
    }
}