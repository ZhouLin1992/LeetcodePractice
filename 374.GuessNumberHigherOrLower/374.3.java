/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution {
	public int guessNumber(int n) {
		int start = 1, end = n;
		if (guess(start) == 0) return start;
		if (guess(end) == 0) return end;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (guess(mid) == -1) end = mid - 1;
			else if (guess(mid) == 1) start = mid + 1;
			else return mid;
		}
		return -1;
	}
}