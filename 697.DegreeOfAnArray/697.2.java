class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = map.get(nums[i]);
            if (tmp == null) {
                tmp = new int[]{1, i, i};
                map.put(nums[i], tmp);
            } else {
                tmp[0] ++;
                tmp[2] = i;
            }
        }
        
        int degree = Integer.MIN_VALUE;
        int len = Integer.MAX_VALUE;
        for (int[] vals : map.values()) {
            if (vals[0] > degree) {
                degree = vals[0];
                len = vals[2] - vals[1] + 1;
            } else if (vals[0] == degree) {
                len = Math.min(len, vals[2] - vals[1] + 1);
            }
        }
        
        return len;
    }
}