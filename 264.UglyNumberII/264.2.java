// HashSet + PriorityQueue
// for every number, we need to multiple it with 2/3/5 seperately
// after each insertion, the new input number needs to be heapified
// in the binary heap, which costs O(log(N))
// so time complexity is O(NlogN)

public class Solution {
	public int nthUglyNumber(int n) {
		if (n <= 1) {
			return n;
		}

		Queue<Long> q = new PriorityQueue<>();
		Set<Long> set = new HashSet<>();
		Long[] primes = new Long[3];
		primes[0] = Long.valueOf(2);
		primes[1] = Long.valueOf(3);
		primes[2] = Long.valueOf(5);
		for (Long p: primes) {
			q.add(p);
			set.add(p);
		}

		Long ans = Long.valueOf(1);
		for (int count = 1; count < n; count++) {
			ans = q.poll();
			for (int i = 0; i < 3; i++) {
				if (set.contains(primes[i] * ans)) {
					continue;
				}
				q.add(primes[i] * ans);
				set.add(primes[i] * ans);
			}
		}

		return ans.intValue();
	}
}