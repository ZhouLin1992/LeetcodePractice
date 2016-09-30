public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for(int num: nums)
			hm.put(num, hm.getOrDefault(num, 0) + 1);

		ArrayList<Integer>[] lst = new ArrayList[nums.length + 1];

		for(HashMap.Entry<Integer, Integer> entry: hm.entrySet()) {
			int freq = entry.getValue();
			if (lst[freq] == null)
				lst[freq] = new ArrayList<>();
			lst[freq].add(entry.getKey());
		}

		List<Integer> res = new ArrayList<>();

		for(int pos = lst.length - 1; pos > 0 && res.size() < k; pos--)
			if (lst[pos] != null)
				res.addAll(lst[pos]);		

		return res;        
    }
}