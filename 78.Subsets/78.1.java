public class Solution {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> subsets(int[] nums) {
		for (int count = 1; count <= nums.length; count++) 
			subsets(nums, count, new ArrayList<Integer>(), 0);
		res.add(new ArrayList<Integer>());
		return res;
	}

	public void subsets(int[] nums, int count, ArrayList<Integer> cur, int start) {
		if (count > 0) {
			for (int i = start; i < nums.length; i++) {
				cur.add(nums[i]);
				subsets(nums, count - 1, cur, i + 1);
				cur.remove(cur.size() - 1);
			}
		} else 
			res.add(new ArrayList<Integer>(cur));
	}
}