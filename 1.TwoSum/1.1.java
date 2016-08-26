public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		int len = nums.length;
		if (len >= 2) {
			for (int i = 0; i < len - 1; i++) {
				hashmap.put(new Integer(nums[i]), new Integer(i));
				int diff = target - nums[i];
				if (hashmap.containsKey(diff)) {
					int[] result = {hashmap.get(diff), hashmap.get(nums[i])};
					return result;
				}
			}
		} 
		int[] output = {-1, -1};
		return output;
	}
}