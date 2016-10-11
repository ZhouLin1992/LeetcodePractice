public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    Arrays.sort(nums);
		subsetsWithDup(nums, 0, new ArrayList<Integer>());
		return res;
	}

	public void subsetsWithDup(int[] nums, int start, ArrayList<Integer> cur) {
		res.add(new ArrayList<Integer>(cur));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue;
			cur.add(nums[i]);
			subsetsWithDup(nums, i + 1, cur);
			cur.remove(cur.size() - 1);
		}
	}
}