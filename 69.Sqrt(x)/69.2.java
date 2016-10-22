public class Solution {
	public int mySqrt(int x) {
		if (x <= 1) return x;
		return mySqrt(x, 1, x);
	}


	public int mySqrt(int x, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid)
				return mid;
			if (mid < x / mid)
				return mySqrt(x, mid + 1, right);
			return mySqrt(x, left, mid - 1);			
		}
		return right;
	}
}