public class Solution {
	public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
		int count1 = 0, place = 0;
		while (num != 0) {
			count1 += (num & 1);
			place++;
			num >>>= 1;
		}
		if (count1 > 1 || count1 == 1 && place % 2 == 0) return false;
		return true;
	}
}