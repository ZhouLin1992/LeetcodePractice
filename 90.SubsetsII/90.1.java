public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    Arrays.sort(nums);
		subsetsWithDup(nums, 0, new ArrayList<Integer>());
		return res;
	}

	public void subsetsWithDup(int[] nums, int start, ArrayList<Integer> cur) {
		res.add(new ArrayList<Integer>(cur));
		int i = start;
		while (i < nums.length) {
			cur.add(nums[i]);
			subsetsWithDup(nums, i + 1, cur);
			cur.remove(cur.size() - 1);
			i++;
			while(i < nums.length && nums[i] == nums[i - 1]) 
				i++;
		}
	}
}