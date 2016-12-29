// 数论中有著名的四方定理：所有自然数至多只要用四个数的平方和就可以表示。

public class Solution {
	public int numSquares(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7) {
			return 4;
		}
		if (isSquare(n)) {
			return 1;
		}
		int sqrt_n = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt_n; i++) {
			if (isSquare(n - i * i)) {
				return 2;
			}
		}
		return 3;
	}

	private boolean isSquare(int n) {
		int s = (int) Math.sqrt(n);
		return s * s == n;
	}
}