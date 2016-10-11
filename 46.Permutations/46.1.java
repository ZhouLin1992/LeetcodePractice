public class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<>(), tmpRes;
		res.add(new LinkedList<Integer>());

		for (int i = 0; i < nums.length; i++) {
			tmpRes = new LinkedList<>();
			for (List<Integer> t: res) {
				for (int j = 0; j < t.size() + 1; j++) {
					List<Integer> tmp = new LinkedList<>(t);
					tmp.add(j, nums[i]);
					tmpRes.add(tmp);
				}
			}
			res = tmpRes;
		}
		return res;        
    }
}