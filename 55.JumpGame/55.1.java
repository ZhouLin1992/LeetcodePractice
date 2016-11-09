// might be TLE

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
		if (A == null || A.length == 0) {
			return true;
		}

		// state
		boolean[] state = new boolean[A.length];

		// initialization
		state[0] = true;

		for (int cur = 1; cur < A.length; cur++) {
			for (int bef = 0; bef < cur; bef++) {
				if (state[bef] && A[bef] >= cur - bef) {
					state[cur] = true;
					break;
				}
			}
		}

		// answer
		return state[A.length - 1];   
    }
}
