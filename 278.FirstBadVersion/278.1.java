/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
		if (n <= 1) return n;
		int start = 1, end = n, mid;
		while (start < end) {
			mid = start + (end - start) / 2;
			// or mid = (start + end) >>> 1;
			if (isBadVersion(mid)) end = mid;
			else start = mid + 1; 
		}
		return start;
    }
}