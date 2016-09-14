public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) return new int[0];

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int[] intersection = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
		int count = 0;

		for (int i : nums1)
			if (count == 0 || intersection[count - 1] != i)
				if (Arrays.binarySearch(nums2, i) >= 0)
					intersection[count++] = i;

		int[] res = Arrays.copyOf(intersection, count);

		return res;
    }
}