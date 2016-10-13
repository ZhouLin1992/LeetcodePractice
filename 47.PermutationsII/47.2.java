public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	int[] copy;
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		copy = nums;
		boolean[] mark = new boolean[nums.length];
		permuteUnique(copy, mark, new LinkedList<Integer>());
		return res;
	}

	public void permuteUnique(int[] copy, boolean[] mark, LinkedList<Integer> cur) {
		if (cur.size() == copy.length) {
			res.add(new LinkedList<Integer>(cur));
			return;
		}

		for (int i = 0; i < copy.length; i++) {
			if (mark[i]) continue;
			if (i > 0 && copy[i] == copy[i - 1] && !mark[i - 1]) continue;

			cur.add(copy[i]);
			mark[i] = true;
			permuteUnique(copy, mark, cur);
			mark[i] = false;
			cur.remove(cur.size() - 1);
		}
	}
}