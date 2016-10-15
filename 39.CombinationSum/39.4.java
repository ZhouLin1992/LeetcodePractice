public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<List<Integer>>> dp = new ArrayList<>();
		for (int i = 1; i <= target; i++) {
			List<List<Integer>> lst = new ArrayList<>();
			for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
				if (candidates[j] == i) 
					lst.add(Arrays.asList(candidates[j]));
				else {
					for (List<Integer> tmp: dp.get(i - candidates[j] - 1)) {
						if (candidates[j] <= tmp.get(0)) {
							List<Integer> c = new ArrayList<>();
							c.add(candidates[j]);
							c.addAll(tmp);
							lst.add(c);
						}
					}
				}
			}
			dp.add(lst);
		}
		return dp.get(target - 1);
	}
}