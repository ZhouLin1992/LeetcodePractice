/* Assume that the number of elements in A and B are both larger than k/2, 
and if we compare the k/2-th smallest element in A(i.e. A[k/2-1]) and the 
k-th smallest element in B(i.e. B[k/2 - 1]), there are three results:
(Becasue k can be odd or even number, so we assume k is even number here 
for simplicy. The following is also true when k is an odd number.)
		A[k/2-1] = B[k/2-1]
		A[k/2-1] > B[k/2-1]
		A[k/2-1] < B[k/2-1]
if A[k/2-1] < B[k/2-1], that means all the elements from A[0] to A[k/2-1]
(i.e. the k/2 smallest elements in A) are in the range of k smallest elements 
in the union of A and B. Or, in the other word, A[k/2 - 1] can never be larger 
than the k-th smalleset element in the union of A and B.

We can use a proof by contradiction. Since A[k/2 - 1] is larger than the k-th 
smallest element in the union of A and B, then we assume it is the (k+1)-th 
smallest one. Since it is smaller than B[k/2 - 1], then B[k/2 - 1] should be 
at least the (k+2)-th smallest one. So there are at most (k/2-1) elements 
smaller than A[k/2-1] in A, and at most (k/2 - 1) elements smaller than A[k/2-1] 
in B.So the total number is k/2+k/2-2, which, no matter when k is odd or even, 
is surly smaller than k(since A[k/2-1] is the (k+1)-th smallest element). So 
A[k/2-1] can never larger than the k-th smallest element in the union of A and 
B if A[k/2-1]<B[k/2-1];
Since there is such an important conclusion, we can safely drop the first k/2 
element in A, which are definitaly smaller than k-th element in the union of A 
and B. This is also true for the A[k/2-1] > B[k/2-1] condition, which we should 
drop the elements in B.

时间： O(log(min(M, N)))
*/


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
		// edge case 1: when one array is too long and the other one is too short/empty
		if (s1 >= nums1.length) {
			return nums2[s2 + k - 1];
		}

		if (s2 >= nums2.length) {
			return nums1[s1 + k - 1];
		}

		// edge case 2: when k = 1, 因为不可能再分了
		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}

		int v1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
		int v2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;

		if (v1 < v2) {
			return findMedianSortedArraysHelper(nums1, s1 + k / 2, nums2, s2, k - k / 2);
		}
		return findMedianSortedArraysHelper(nums1, s1, nums2, s2 + k / 2, k - k / 2);
	}
}