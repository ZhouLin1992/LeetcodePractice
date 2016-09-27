public class Solution {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer> hashset = new HashSet<>();

		for (int num: nums) {
			if (!hashset.contains(num))
				hashset.add(num);
			else 
				hashset.remove(num);
		}
		Object[] res = hashset.toArray();
		return new int[]{res[0], res[1]};
	}
}