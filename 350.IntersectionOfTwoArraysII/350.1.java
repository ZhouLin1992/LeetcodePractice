public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == 0 || nums2 == 0) return new int[0];

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int p1 = 0, p2 = 0, c = 0;
		int[] intersection = new int[Math.min(nums1.length, nums2.length)];

		while (p1 < nums1.length && p2 < nums2.length)
			if (nums1[p1] < nums2[p2]) p1++;
			else if (nums1[p1] > nums2[p2]) p2++;
			else {
				intersection[c++] = nums1[p1];
				p1++;
				p2++;
			}	

		int[] res = Arrays.copyOf(intersection, c);
		return res;
	}
}