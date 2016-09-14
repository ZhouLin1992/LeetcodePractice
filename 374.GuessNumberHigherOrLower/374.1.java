/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution {
	public int guessNumber(int n) {
		if (n == 1) return 1;

		Random rand = new Random();

		int gs = rand.nextInt(n) + 1, min = 1, max = n;

		while (guess(gs) != 0) {
			// if (guess(gs) == -1) {
			// 	max = gs - 1;
			// 	gs = rand.nextInt(max - min + 1) + min;				
			// } else {
			// 	min = gs + 1;
			// 	gs = rand.nextInt(max - (gs + 1)) + (gs + 1); 				
			// }

			if (guess(gs) == -1) max = gs - 1;
			else min = gs + 1;
			gs = rand.nextInt(max - min + 1) + min;
		}
		return gs;
	}
}