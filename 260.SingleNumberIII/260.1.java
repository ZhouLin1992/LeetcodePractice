public class Solution {
    public int[] singleNumber(int[] nums) {
		int ref = 0;
		for (int i: nums) 
			ref ^= i;
		ref &= (-ref);
		int first = 0, second = 0;
		for (int i: nums) {
			if ((i & ref) == 0)
				first ^= i;
			else
				second ^= i;
		}
		return new int[]{first, second};
    }
}