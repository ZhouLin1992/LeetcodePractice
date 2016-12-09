// Ugly number is the number which is multiple of definite numbers of 2, 3, 5
// Time: O(N)
// Space: O(N)
// Analysis:
// 1. Use array to store already calculated ugly numbers, the first ugly number is 1
// 2. idx2, idx3, idx5 is the index of the array, the initailzed index is 0
// 3. Min(un[idx2]*2, un[idx3]*3, un[idx5]*5)
// 4. if min equals to several multiplication, several index needs to plus 1


public class Solution {
	public int nthUglyNumber(int n) {
		if (n <= 1) {
			return n;
		}

		int[] un = new int[n];
		int idx2 = 0;
		int idx3 = 0;
		int idx5 = 0;
		un[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = Math.min(un[idx2] * 2, Math.min(un[idx3] * 3, un[idx5] * 5));
			if (min == un[idx2] * 2) {
				idx2++;
			}
			if (min == un[idx3] * 3) {
				idx3++;
			}
			if (min == un[idx5] * 5) {
				idx5++;
			}
			un[i] = min;
		}
		return un[n - 1];
	}
}