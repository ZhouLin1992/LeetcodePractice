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

	public void partition(int pos, LinkedList<String> cur) {
		if (pos == len) {
			res.add(new LinkedList<String>(cur));
			return;		
		}

		for (int i = pos; i < len; i++) {
			if (isPalindrome(pos, i)) {
				cur.add(str.substring(pos, i + 1));
				partition(i + 1, cur);
				cur.remove(cur.size() - 1);
			}
		}

	}

	public boolean isPalindrome(int start, int end) {
		while (start < end) 
			if (str.charAt(start++) != str.charAt(end--))
				return false;
		return true;
	}
}