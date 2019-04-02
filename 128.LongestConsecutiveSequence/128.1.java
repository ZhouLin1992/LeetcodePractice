// Analysis:
// find out the left and right bound of a subsequence
// time complexity of putting every element into set is O(N)
// traverse every element in the set only once, time complexity is O(N)

public class Solution {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();

		// put all elements into set
		for (int num: nums) {
			set.add(num);
		}

		int maxLength = 0;
		for (int num: nums) {
			if (!set.contains(num)) {
				continue;
			}
            
            int count = 1;
			int low = num - 1;
			while (set.contains(low)) {
				// 及时的移除，减少之后的查找时间
				set.remove(low);
				low--;
				count++;
			}

			int high = num + 1;
			while (set.contains(high)) {
				set.remove(high);
				high++;
				count++;
			}
			set.remove(num);

			maxLength = Math.max(maxLength, count);
		}

		return maxLength;
	}
}