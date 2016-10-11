public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	int[] copy;
	int n;
	public List<List<Integer>> permute(int[] nums) {
		copy = nums;
		n = nums.length;
		permute(0);
		return res;
	}

	public void permute(int start) {
		if (start == n) {
			List<Integer> tmp = new LinkedList<>();
			for (int num: copy)
				tmp.add(num);
			res.add(tmp);
			return;
		}

		for (int i = start; i < n; i++) {
			swap(start, i);
			permute(start + 1);
			swap(start, i);
		}
	}


	private void swap(int start, int i) {
		if (start == i) return;
		copy[start] ^= copy[i];
		copy[i] ^= copy[start];
		copy[start] ^= copy[i];
	}
}