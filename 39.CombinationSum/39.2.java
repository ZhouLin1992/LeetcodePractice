public class Solution {
	int[] nums;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		nums = candidates;
		return combinationSum(target, 0);
	}

	public List<List<Integer>> combinationSum(int target, int start) {
	    List<List<Integer>> res = new LinkedList<>();
	    
		for (int i = start; i < nums.length; i++) {
			if (nums[i] < target) {
				for (List<Integer> r: combinationSum(target - nums[i], i)) {
					r.add(nums[i]);
					res.add(r);
				}
			} else if (nums[i] == target) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(nums[i]);
				res.add(tmp);
			} else 
				break;
		}
		return res;
	}
}