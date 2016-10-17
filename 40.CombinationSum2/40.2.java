public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	int[] copy;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		copy = candidates;
		combinationSum2(target, 0, new ArrayList<Integer>());
		return res;
	}

	public void combinationSum2(int target, int start, ArrayList<Integer>() cur) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}

		if (target < 0) return;

		for (int i = start; i < copy.length; i++) {
			if (i > start && copy[i] == copy[i - 1]) continue;
			cur.add(copy[i]);
			combinationSum2(target - copy[i], i + 1, cur);
			cur.remove(cur.size() - 1);
		}
	}
}