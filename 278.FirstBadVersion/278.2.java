/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
		if(n <= 1)
			return n;

		int lo = 1, hi = n;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (isBadVersion(mid))
				hi = mid;
			else 
				lo = mid;
		}

		if (isBadVersion(lo))
			return lo;
		return hi;
    }
}