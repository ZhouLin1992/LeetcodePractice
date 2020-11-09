class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        
        int sum = 0;
        int start = 0;
        int minLenSoFar = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        // store the min length of sum found so far
        int[] minLen = new int[arr.length];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            
            if (sum == target) {
                if (start > 0 && minLen[start - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, minLen[start - 1] + i - start + 1);
                }
                minLenSoFar = Math.min(minLenSoFar, i - start + 1);
            }
            minLen[i] = minLenSoFar;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}