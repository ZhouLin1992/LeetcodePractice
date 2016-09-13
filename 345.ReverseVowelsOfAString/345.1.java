public class Solution {
    public String reverseVowels(String s) {
		if (s.length() <= 1) return s;
		// char[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		// Set set = new HashSet();
		// for (int i = 0; i < chars.length; i++) set.add(chars[i]);

		String set = "aeiouAEIOU";

		char[] ss = s.toCharArray();

		int start = 0, end = s.length() - 1;

		while(start < end) {
			// while(!set.contains(ss[start] + "") && start < end) start++;
			// while(!set.contains(ss[end] + "") && end > start) end--;

			// while(!set.contains(ss[start]) && start < end) start++;
			// while(!set.contains(ss[end]) && end > start) end--;

			while(start < end && set.indexOf(ss[start]) == -1) start++;
			while(end > start && set.indexOf(ss[end]) == -1) end--;
			char tmp = ss[start];
			ss[start] = ss[end];
			ss[end] = tmp;
			start++;
			end--;
		}
		return new String(ss);   
    }
}