public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) return new int[0];

		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i: nums1) 
			if (hm.containsKey(i))
				hm.put(i, hm.get(i) + 1);
			else 
				hm.put(i, 1);

		for (int j: nums2)
			if (hm.containsKey(j) && hm.get(j) > 0) {
				list.add(j);
				hm.put(j, hm.get(j) - 1);
			}
				

		int[] res = new int[list.size()];
		int ind = 0;
		for (Integer i: list) res[ind] = i;

		return res;
    }
}