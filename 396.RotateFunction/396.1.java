public class Solution {
    public int maxRotateFunction(int[] A) {
		int sum = 0, tmp = 0;

		for (int i = 0; i < A.length; i++) {
			sum += i * A[i];
			tmp += A[i];			
		}


		int max = sum;
		for (int i = A.length - 1; i >= 0; i--) {
			sum += tmp - A.length * A[i];
			if (sum > max) max = sum;
		}

		return max;
    }
}