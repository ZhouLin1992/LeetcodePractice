public class Solution {
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int count = n / 2;
		for (int i = 3; i * i < n; i += 2) {
			if (notPrime[i]) continue;
			for (int j = i * i; j < n; j += 2 * i) {
				if (!notPrime[j]) {
					count--;
					notPrime[j] = true;
				}
			}
		}
		return count;
	}
}