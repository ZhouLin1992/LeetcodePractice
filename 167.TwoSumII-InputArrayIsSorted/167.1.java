public class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int lo = 0, hi = numbers.length - 1;
		while (lo < hi) {
			int tmp = numbers[lo] + numbers[hi];
			if (tmp == target) 
				return new int[]{lo + 1, hi + 1};
			else if (tmp < target) 
				lo++;
			else 
				hi--;			
		}
		return null;     
    }
}