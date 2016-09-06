public class Solution {
	public int countPrimes(int n) {
		if (n <= 2) return 0;
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		int count = 1;
		for (int i = 3; i < n; i += 2) {
			if(isPrime(i, prime)) count++;
		}
		return count;
	}

	public boolean isPrime(int num, ArrayList<Integer> prime) {
		for (int i = 0; prime.get(i) * prime.get(i) <= num; i++) {
			if (num % prime.get(i) == 0) return false;
		}
		prime.add(num);
		return true;
	}
}