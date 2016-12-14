// use PriorityQueue(Min Heap) for polling out the smallest one each time
// repeat the following process for (k -1) times:
// 1. poll out the smallest one of the pq
// 2. insert a new one from the nums1
// Time complexity: O(klogk)

public class Solution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return res;
		}

		int len1 = nums1.length;
		int len2 = nums2.length;

		Queue<Tuple> pq = new PriorityQueue<Tuple> ();

		// initialization
		for (int j = 0; j < nums2.length; j++) {
			pq.add(new Tuple(nums1[0] + nums2[j], 0, j));
		}

		for (int i = 0; i < Math.min(len1 * len2, k); i++) {
			Tuple tmp = pq.poll();
			res.add(new int[] {nums1[tmp.index1], nums2[tmp.index2]});
			if (tmp.index1 == len1 - 1) {
				continue;
			}
			pq.add(new Tuple(nums1[tmp.index1 + 1] + nums2[tmp.index2], tmp.index1 + 1, tmp.index2));
		}

		return res;
	}
}

class Tuple implements Comparable<Tuple> {
	int val;
	int index1;
	int index2;
	public Tuple(int val, int index1, int index2) {
		this.val = val;
		this.index1 = index1;
		this.index2 = index2;
	}

	@Override
	public int compareTo(Tuple that) {
		return this.val - that.val;
	}
}