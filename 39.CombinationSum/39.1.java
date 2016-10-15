public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		combination(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	public void combination(List<List<Integer>> res, ArrayList<Integer> cur, int[] candidates, int target, int start) {
		if (target > 0) {
			for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
				cur.add(candidates[i]);
				combination(res, cur, candidates, target - candidates[i], i);
				cur.remove(cur.size() - 1);
			}			
		} else {
			res.add(new ArrayList<Integer>(cur));
		}        
    }
}