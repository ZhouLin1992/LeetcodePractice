class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        for (int i = 0; i < len; i++) {
            count += map.containsKey(sum[i] - k) ? map.get(sum[i] - k) : 0;
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return count;
    }
}