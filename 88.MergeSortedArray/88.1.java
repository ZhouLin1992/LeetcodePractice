public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0 && n == 0) return;
        if (m != 0 && n == 0) return;
        if (m == 0 && n != 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        
		int[] res = IntStream.concat(getStream(nums1, m), getStream(nums2, n)).sorted().toArray();
		System.arraycopy(res, 0, nums1, 0, m + n);
	}

	private IntStream getStream(int[] nums, int len) {
		return Arrays.stream(nums, 0, len);
	}
}