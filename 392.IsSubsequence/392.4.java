//follow-up question

public class Solution {
    public boolean isSubsequence(String s, String t) {
		HashMap<Character, List<Integer>> hm = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			if (!hm.containsKey(t.charAt(i)))
				hm.put(t.charAt(i), new ArrayList<Integer>());
			hm.get(t.charAt(i)).add(i);
		}

		int index = -1;
		for (int j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);
			int nextIndex = getNextIndex(hm.get(ch), index);
			if (nextIndex == -1) return false;
			index = nextIndex;
		}
		return true;
	}

	public int getNextIndex(List<Integer> lst, int index) {
		if (lst == null) return -1;
		int start = 0, end = lst.size() - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (lst.get(mid) <= index) start = mid + 1;
			else end = mid;
		}
		return lst.get(start) > index ? lst.get(start) : -1;   
    }
}