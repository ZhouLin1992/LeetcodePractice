class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int result = -1;
        while (left < right) {
            int sum = A[left] + A[right];
            if (sum < K) {
                result = Math.max(result, sum);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}