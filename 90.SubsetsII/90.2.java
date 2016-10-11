public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		int begin = 0;
		for(int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) begin = 0;
			int size = res.size();
			for (int j = begin; j < size; j++) {
				List<Integer> tmp = new ArrayList<>(res.get(j));
				tmp.add(nums[i]);
				res.add(tmp);
			}
			begin = size;
		}
		return res;
	}
}