/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
	public int guessNumber(int n) {
	    if (n == 1) return 1;
		return guessNumber(1, n);
	}

	public int guessNumber(int start, int end) {
        if (guess(start) == 0) return start;
        if (guess(end) == 0) return end;
		while (start < end) {
			int mid = start + (end - start) / 2;
			// or faster
			// int mid = start + end >>> 1;
			if (guess(mid) == -1) return guessNumber(start, mid - 1);
			else if (guess(mid) == 1) return guessNumber(mid + 1, end);
			else return mid;
		}
		return -1;
	}
}