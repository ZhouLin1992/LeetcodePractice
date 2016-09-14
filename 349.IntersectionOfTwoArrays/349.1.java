public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
// 		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
// 			return null;

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int i: nums1) 
			set1.add(i);

		for (int i: nums2)
			if (set1.contains(i))
				set2.add(i);

		int[] tmp = new int[set2.size()];
		int ind = 0;
		for (Integer i: set2) 
			tmp[ind++] = i;

		return tmp;
    }
}