public class Solution {
	String str;
	boolean[][] mark;
	List<List<String>> res = new LinkedList<>();
	public List<List<String>> partition(String s) {
		str = s;
		int len = s.length();
		mark = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == str.charAt(j) && ((i - j <= 2 ) || (mark[j + 1][i - 1] == true)))
					mark[j][i] = true;
			}
		}
		partition(0, new LinkedList<String>());
		return res;
	}

	public void partition(int pos, LinkedList<String> cur) {
		if (pos == str.length()) {
			res.add(new LinkedList<String>(cur));
			return;
		}

		for (int i = pos; i < str.length(); i++) {
			if (mark[pos][i]) {
				cur.add(str.substring(pos, i + 1));
				partition(i + 1, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
}