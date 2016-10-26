public class Solution {
    public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		for (int i = 0; i < nums.length; i++) {
			int start = nums[i];
			while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1)
				i++;
			if (start == nums[i])
				res.add("" + start);
			else 
				res.add(start + "->" + nums[i]);
		}
		return res;
    }
}