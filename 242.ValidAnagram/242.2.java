public class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		char[] arr1 = s.toCharArray;
		char[] arr2 = s.toCharArray;

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < s.length; i++) {
			if (arr1[i] != arr2[i]) return false;
		}
		return true;
	}
}