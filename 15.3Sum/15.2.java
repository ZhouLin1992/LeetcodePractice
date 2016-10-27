public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return res;
		for (int p1 = 0; p1 < nums.length - 2; p1++) {
			if (p1 == 0 || (p1 > 0 && nums[p1] != nums[p1 - 1])) {
				int sum = 0 - nums[p1], start = p1 + 1, end = nums.length - 1;
				while (start < end) {
				    if (nums[start] + nums[end] == sum) {
    					res.add(Arrays.asList(nums[p1], nums[start], nums[end]));
    					while (start < end && nums[start + 1] == nums[start])
    						start++;
    					while (start < end && nums[end - 1] == nums[end])
    						end--;
    					start++;
    					end--;
    				} else if (nums[start] + nums[end] < sum) {
    					// check duplicates
    				    while (start < end && nums[start + 1] == nums[start])
    				        start++;
    					start++;
    				} else {
    					// check duplicates
    				    while (start < end && nums[end - 1] == nums[end])
    				        end--;
    					end--;
    				}
				}
			}
		}
		return res;
    }
}