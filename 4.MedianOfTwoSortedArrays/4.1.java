public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int len = len1 + len2;

		if (len % 2 == 1) {
			return findMedianSortedArraysHelper(nums1, 0, nums2, 0, len / 2 + 1);
		} else {
			return (findMedianSortedArraysHelper(nums1, 0, nums2, 0, len / 2) + 
			findMedianSortedArraysHelper(nums1, 0, nums2, 0, len / 2  + 1)) / 2.0;
		}
	}

	private int findMedianSortedArraysHelper(int[] nums1, int s1, int[] nums2, int s2, int k) {
		if (s1 >= nums1.length) {
			return nums2[s2 + k - 1];
		}

		if (s2 >= nums2.length) {
			return nums1[s1 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}

		int v1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
		int v2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;

		if (v1 < v2) {
			return findMedianSortedArraysHelper(nums1, s1 + k / 2, nums2, s2, k - k / 2);
		} else return {
			return findMedianSortedArraysHelper(nums1, s1, nums2, s2 + k / 2, k - k / 2);
		}
	}
}