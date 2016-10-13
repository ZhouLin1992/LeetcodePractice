public class Solution {
	public List<List<String>> partition(String s) {
		int len = s.length();
		boolean[][] mark = new boolean[len][len];
		List<List<String>>[] res = new List[len + 1];
		res[0] = new ArrayList<List<String>>();
		res[0].add(new ArrayList<String>());

		for (int right = 0; right < len; right++) {
			res[right + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= right; left++) {
				if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || mark[left + 1][right - 1])) {
					mark[left][right] = true;
					String tmp = s.substring(left, right + 1);
					for (List<String> l: res[left]) {
						ArrayList<String> r = new ArrayList<>(l);
						r.add(tmp);
						res[right + 1].add(r);
					}
				}
			}
		}
		return res[len];
	}
}