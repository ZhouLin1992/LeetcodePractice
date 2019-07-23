class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!left.containsKey(num)) {
                left.put(num, i);
            }
            right.put(num, i);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int len = nums.length;
        int degree = Collections.max(count.values());
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == degree) {
                len = Math.min(len, right.get(key) - left.get(key) + 1) ;
            }
        }
        
        return len;
    }
}