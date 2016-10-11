public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	public List<List<Integer>> permute(int[] nums) {
		permute(nums, 0);
		return res;
	}

	public void permute(int[] nums, int start) {
		if (start == nums.length) {
			List<Integer> tmp = new LinkedList<>();
			for (int n: nums) 
				tmp.add(n);
			res.add(tmp);
			return;
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			permute(nums, start + 1);
			swap(nums, start, i);
		}

	}


	public void swap(int[] nums, int start, int i) {
	    if (start == i) return;
		int tmp = nums[start];
		nums[start] = nums[i];
		nums[i] = tmp;
	}
}