public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();

		for(int num: nums) 
			hm.put(num, hm.getOrDefault(num, 0) + 1);

		TreeMap<Integer, List<Integer>> tm = new TreeMap<>();

        for(int key: hm.keySet()) {
            int freq = hm.get(key);
            if (!tm.containsKey(freq))
                tm.put(freq, new LinkedList<>());
            tm.get(freq).add(key);
        }

		List<Integer> res = new ArrayList<>();

		while(res.size() < k) {
			Map.Entry<Integer, List<Integer>> entry = tm.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;      
    }
}