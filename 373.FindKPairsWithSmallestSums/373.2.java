// Time complexity: O(k * len) where len is the shortest array
// for each element in the result, compare every nums1[i] + nums2[index[i]]
// find out the smallest (To put it in another way, keep track of the paired index)

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();	

		if (nums1 == null || nums2 == null || nums1.length == 0 || nums.length == 0) {
			return res;
		}

		int[] index = new int[nums1.length];
		
		while (k-- > 0) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int i = 0; i < nums1.length; i++) {
				// for index i in nums1, it has already added up all numbers in nums2
				if (index[i] == nums2.length) {
					continue;
				}

				// find the minimum
				if (nums1[i] + nums2[index[i]] < min) {
					min = nums1[i] + nums2[index[i]];
					idx = i;
				}
			}
			// not sure len1 * len2 - 1 ><=? k, we need to check
			if (idx == -1) {
				break;
			}

			int[] pairs = {nums1[idx], nums2[index[idx]]};
			res.add(pairs);
			index[idx]++;
		}
		return res;
	}
}