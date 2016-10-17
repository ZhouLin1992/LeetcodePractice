public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int sum = 0;
		int mark = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
				sum += ++mark;
			else
				mark = 0;
		}
		return sum;
	}
}