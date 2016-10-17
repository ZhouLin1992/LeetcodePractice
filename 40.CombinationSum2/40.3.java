public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	int[] copy;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		copy = candidates;
		combinationSum2(target, 0, new int[copy.length], 0);
		return res;
	}

	public void combinationSum2(int target, int start, int[] sub, int index) {
		if (target == 0) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < index; i++) {
				tmp.add(sub[i]);
			}
			res.add(tmp);
			return;
		}

		int prev = 0;
		for (int i = start; i < copy.length; i++) {
			if (copy[i] != prev) {
				if (target - copy[i] < 0) 
					break;
					
    			sub[index] = copy[i];
    			combinationSum2(target - copy[i], i + 1, sub, index + 1);
    			prev = copy[i];
			}
		}
	}
}