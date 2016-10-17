public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int start = 0, p = 2, sum = 0;
		while (start < A.length - 2) {
			if (p < A.length && A[p] - A[p - 1] == A[p - 1] - A[p - 2])
				p++;
			else {
				int len = p - start;
				if (len >= 3)
					sum += (len - 1) * (len - 2) / 2;
				start = p - 1;
				p = p + 1;
			}
		}
		return sum;
	}
}