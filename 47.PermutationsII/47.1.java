public class Solution {
	List<List<Integer>> res = new LinkedList<>();
	int n;
	public List<List<Integer>> permuteUnique(int[] nums) {
		n = nums.length;
		if(n == 0) return res;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int n: nums)
			hm.put(n, hm.getOrDefault(n, 0) + 1);

		permuteUnique(hm, new LinkedList<Integer>());
		return res;
	}

	public void permuteUnique(Map<Integer, Integer> hashmap, LinkedList<Integer> cur) {
		if (cur.size() == n) {
			res.add(new LinkedList<>(cur));
			return;
		}
		for (Map.Entry<Integer, Integer> entry: hashmap.entrySet()) {
			if (entry.getValue() > 0) {
				cur.add(entry.getKey());
				hashmap.put(entry.getKey(), entry.getValue() - 1);
				permuteUnique(hashmap, cur);
				hashmap.put(entry.getKey(), entry.getValue() + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}
}