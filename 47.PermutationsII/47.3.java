public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	int[] copy;
	int n;
	public List<List<Integer>> permuteUnique(int[] nums) {
		copy = nums;
		n = nums.length;
		permuteUnique(0);
		return res;
	}

	public void permuteUnique(int start) {
	
		if (start == n - 1) {
			List<Integer> tmp = new LinkedList<>();
			for (int n: copy)
				tmp.add(n);
			res.add(tmp);
			return;
		}

		// Set<Integer> set = new HashSet<>();
		for (int i = start; i < n; i++) {
			// if (set.add(copy[i])) {
			if (!isDuplicate(start, i)) {
				swap(start, i);
				permuteUnique(start + 1);
				swap(start, i);
			}
		}
	}

	public void swap(int start, int i) {
		if (start == i) return;
		copy[start] ^= copy[i];
		copy[i] ^= copy[start];
		copy[start] ^= copy[i];
	}

	public boolean isDuplicate(int start, int i) {
		for (int t = start; t < i; t++) {
			if (copy[t] == copy[i])
				return true;
		}
		return false;
	}
}