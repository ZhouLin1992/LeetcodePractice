// https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

class Solution {
    public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0 || points[0].length == 0) {
			return new int[0][0];
		}

		int left = 0;
		int right = points.length - 1;
		while (left < right) {
			int index = quickSort(left, right, points);
			if (index == K) {
				break;
			} else if (index < K) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}

		return Arrays.copyOfRange(points, 0, K);
    }

   	private int quickSort(int left, int right, int[][] points) {
   		int[] pivot = points[left];
   		while (left < right) {
   			while (left < right && compare(pivot, points[right]) < 0) {
   				right--;
   			}
   			points[left] = points[right];
   			while (left < right && compare(pivot, points[left]) >= 0) {
   				left++;
   			}
   			points[right] = points[left];
   		}
   		points[left] = pivot;
   		return left;
   	}

   	private int compare(int[] p1, int[] p2) {
   		return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
   	}
}