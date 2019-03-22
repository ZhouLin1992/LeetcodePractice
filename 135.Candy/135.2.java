// https://leetcode.com/problems/candy/discuss/135698/Simple-solution-with-one-pass-using-O(1)-space

class Solution {
    public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int down = 0;
		int up = 0;
		// deal with case when first going up then going down, remember the peak
		int peak = 0;
		// scan from left to right, first child is given 1 candy
		int sum = 1;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				down = 0;
				peak = ++up;
				sum += up + 1;
			} else (ratings[i - 1] == ratings[i]) {
				down = 0;
				up = 0;
				peak = 0;
				sum += 1;
			} else {
				up = 0;
				down++;
				sum += down + 1 + (peak >= down ? -1 : 0);
			}
		}

		return sum;
    }
}