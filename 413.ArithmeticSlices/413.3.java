public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int sum = 0, len = 2, pointer = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
				len++;
			else {
				if (len > 2) 
					sum += (len - 1) * (len - 2) / 2;
				len = 2;
			}
		}
		if (len > 2) sum += (len - 1) * (len - 2) / 2;
		return sum;
	}
}