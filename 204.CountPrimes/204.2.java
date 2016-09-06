public class Solution {
	public int countPrimes(int n) {
		if (n <= 2) return 0;
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if(notPrime[i]) {
				continue;
			}
			for (int j = 2; i * j < n; j++) {
				notPrime[i * j] = true;
			}
			count++;
		}
		return count;
	}
}