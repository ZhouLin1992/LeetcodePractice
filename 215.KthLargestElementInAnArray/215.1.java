// Time: O(Nlogk)
// Space: O(K)
// Maintain a min-based priority queue and maintain the pq size

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			minHeap.add(nums[i]);

			// the priority queue needs to maintain the size
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return minHeap.peek();
	}
}