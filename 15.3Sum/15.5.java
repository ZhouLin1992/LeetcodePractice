/*
This method cannot be used because it doesn't work with test case [0, 0, 0]
*/

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();		
		if (nums == null || nums.length < 3) {
			return res;
		}

		int len = nums.length;
		Arrays.sort(nums);

		Map<Integer, int[]> map = new HashMap<>();
		int i = 0;

		// Since the array is already sorted, if the first element is greater than 0,
		// the combination of the three can not equal zero
		while (nums[i] <= 0 && i < len - 2) {
			map.clear();

			// check duplicates
			if(i != 0 && nums[i] == nums[i - 1]) {
				i++;
				continue;
			}

			// the second element starts from (i + 1)
			for (int j = i + 1; j < len; j++) {
				if (map.containsKey(nums[j])) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(map.get(nums[j])[0]);
					tmp.add(map.get(nums[j])[1]);
					tmp.add(nums[j]);
					res.add(tmp);
					while (j < (len - 1) && nums[j] == nums[j + 1]) {
						j++;
					}
				} else {
					int[] tmp = new int[2];
					tmp[0] = nums[i];
					tmp[1] = nums[j];
					map.put(0 - nums[i] - nums[j], tmp);
				}
			}
			i++;
		}
		return res;
	}
}