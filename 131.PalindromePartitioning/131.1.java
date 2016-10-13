public class Solution {
	String str;
	int len;
	List<List<String>> res = new LinkedList<>();
	public List<List<String>> partition(String s) {
		str = s;
		len = s.length();
		partition(0, new LinkedList<String>());
		return res;
	}

	public void partition(int start, LinkedList<String> cur) {
		if (start == len) {
			res.add(new LinkedList<String>());
			return res;
		}

		for (int i = 1; i <= len - start; i++) {
			String tmp = str.substring(start, start + i);
			if (isPalindrome(tmp)) {
				cur.add(tmp);
				partition(start + i, cur);
				cur.remove(tmp);
			}
		}

	}

	public boolean isPalindrome(String tmp) {
		if (tmp.length() == 1) return true;
		return new StringBuilder(tmp).reverse().toString().equals(tmp);
	}
}