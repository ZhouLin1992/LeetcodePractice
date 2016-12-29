// Hashtable

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // getOrDefault(Object key, Default value)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int num: hm.keySet()) {
            if (hm.get(num) > nums.length / 2) {
                res = num;
                return res;
            }
        }
        return res;
    }
}