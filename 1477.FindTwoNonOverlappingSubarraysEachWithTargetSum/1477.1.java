class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        // (key, val): (sum up to index i, i)
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        
        sum = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // stores minimum length of sub-array ending with index<= i with sum target
            // to ensure non-overlapping property.
            if (map.containsKey(sum - target)) {
                minLen = Math.min(minLen, i - map.get(sum - target));
            }
            // searches for any sub-array starting with index i+1 with sum target
            if (map.containsKey(sum + target) && minLen < Integer.MAX_VALUE) {
                //  updates the result only if both left and right sub-array exists
                result = Math.min(result, minLen + map.get(sum + target) - i);
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}