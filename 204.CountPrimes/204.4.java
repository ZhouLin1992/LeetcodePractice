public class Solution {
	public int countPrimes(int n) {
		if (n <= 2) return 0;
		boolean[] notPrime = new boolean[n];
		int count = n / 2;
		for (int i = 3; i * i < n; i += 2) {
			if (!notPrime[i]) {
				for (int j = i * i; j < n; j += 2 * i) {
					count -= notPrime[j] == true ? 0 : 1;
					notPrime[j] = true;
				}
			}
		}
		return count;	
	}
}