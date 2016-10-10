public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int count = 1 << nums.length;
		for (int i = 0; i < count; i++) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if(((1 << j) & i) != 0)
					tmp.add(nums[j]);
			}
			res.add(tmp);
		}
		return res;
	}
}