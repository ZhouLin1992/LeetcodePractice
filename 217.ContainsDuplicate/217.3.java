public class Solution {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.contains(i) return true;
			else map.put(i, 0);
		}
		return false;
	}
}